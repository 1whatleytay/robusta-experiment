package cpu

import util.*

class Cpu {
    private lateinit var memory: Memory
    private var registers = Registers()

    var stop = false

    fun step() {
        val op = memory.get(registers.pc)

        registers.pc++
    }

    fun exec() {
        while (!stop) {
            step()
        }
    }

    fun link(memory: Memory) {
        this.memory = memory

//        val vectors = memory.getVectors()
//        registers.pc = vectors.reset

        registers.pc = 0xC000u;
    }
}