import rom.*
import cpu.*

class Emulator(private val path: String) {
    private val rom = Rom(path)
    private val mapper = Mapper.from(rom)
    private val cpu = Cpu()
    private val memory = Memory(mapper)

    fun run() {
        cpu.exec()
    }

    init {
        cpu.link(memory)
        memory.link(cpu)
    }
}