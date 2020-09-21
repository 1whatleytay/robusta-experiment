package rom

import java.io.File

import util.*

// NES\x1A
val magic = arrayOf<UByte>(0x4Eu, 0x45u, 0x53u, 0x1Au).toUByteArray()

class Rom(path: String) {
    val prgRomSize: UInt
    val chrRomSize: UInt

    val flags: UByteArray

    val prgRom: UByteArray
    val chrRom: UByteArray

    init {
        val file = File(path)
        if (!file.exists())
            throw Exception("File does not exist.")
        val data = file.inputStream().readAllBytes().asUByteArray()
        if (!data.sliceArray(0..3).contentEquals(magic)) {
            throw Exception("File is not an NES file.");
        }
        prgRomSize = data[4] * kb(16).toUInt()
        chrRomSize = data[5] * kb(8).toUInt()
        flags = data.sliceArray(6..10)
        // padding...

        val chrStart = 16 + prgRomSize.toInt()
        val chrEnd = data.size - 1

        prgRom = data.sliceArray(16..chrStart)
        chrRom = data.sliceArray(chrStart..chrEnd)
    }
}