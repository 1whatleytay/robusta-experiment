package rom

import util.*

const val baseIndex = 0x8000

interface Mapper {
    fun get(address: Address): UByte
    fun set(address: Address, value: UByte)

    companion object {
        fun from(rom: Rom): Mapper {
            return NRomMapper(rom)
        }
    }
}

class NRomMapper(private val rom: Rom): Mapper {
    override fun get(address: Address): UByte {
        var index = address.toInt() - baseIndex

        // Trying to simulate the mirror in 16kb nroms without modulo
        if (index > rom.prgRom.size)
            index -= kb(16)

        return rom.prgRom[index]
    }

    override fun set(address: Address, value: UByte) {
        throw Exception("NRom does not have any registers.")
    }
}
