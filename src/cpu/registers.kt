package cpu

import util.*

class Flags {
    var negative = false
    var overflow = false
    var breakEnable = false
    var decimal = false
    var interruptEnable = false
    var zero = false
    var carry = false

    fun load(shift: UByte) {
        var temp = shift.toInt()

        carry = temp.and(1) == 1
        temp = temp.shr(1)
        zero = temp.and(1) == 1
        temp = temp.shr(1)
        interruptEnable = temp.and(1) == 1
        temp = temp.shr(1)
        decimal = temp.and(1) == 1
        temp = temp.shr(1)
        breakEnable = temp.and(1) == 1
        temp = temp.shr(2)
        overflow = temp.and(1) == 1
        temp = temp.shr(1)
        negative = temp.and(1) == 1
    }

    fun evaluate(): UByte {
        var shift = 0

        shift.or(if (negative) 1 else 0)
        shift = shift.shl(1)
        shift.or(if (overflow) 1 else 0)
        shift = shift.shl(2)
        shift.or(if (breakEnable) 1 else 0)
        shift = shift.shl(1)
        shift.or(if (decimal) 1 else 0)
        shift = shift.shl(2)
        shift.or(if (interruptEnable) 1 else 0)
        shift = shift.shl(1)
        shift.or(if (zero) 1 else 0)
        shift = shift.shl(2)
        shift.or(if (carry) 1 else 0)
        shift = shift.shl(1)

        return shift.toUByte()
    }
}

class Registers {
    var a: UByte = 0u
    var x: UByte = 0u
    var y: UByte = 0u

    var pc: Address = 0u
    var flags = Flags()
    var sp: UByte = 0u
}
