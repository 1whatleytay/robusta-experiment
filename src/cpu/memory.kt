package cpu

import rom.*
import util.*

class Vectors(val nmi: Address, val reset: Address, val irq: Address)

class Memory(val mapper: Mapper) {
    private lateinit var cpu: Cpu

    private val ram = UByteArray(kb(2))

    fun get(address: Address): UByte {
        return when (address) {
            in 0x0000u..0x1FFFu -> ram[address.toInt() % 0x800]
            in 0x8000u..0xFFFFu -> mapper.get(address)
            else -> throw Exception("Unmapped read.")
        }
    }

    fun getAddress(address: Address): Address {
        return make(get(address), get((address + 1u).toUShort()))
    }

    fun set(address: Address, value: UByte) {
        when (address) {
            in 0x0000u..0x1FFFu -> ram[address.toInt() % 0x800] = value
            else -> throw Exception("Unmapped write.")
        }
    }

    fun setAddress(address: Address, value: Address) {
        set(address, hi(value))
        set((address + 1u).toUShort(), lo(value))
    }

    fun getVectors() = Vectors(
            getAddress(0xFFFAu),
            getAddress(0xFFFCu),
            getAddress(0xFFFEu))

    fun link(cpu: Cpu) {
        this.cpu = cpu
    }
}