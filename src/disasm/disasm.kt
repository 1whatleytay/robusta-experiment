package disasm

enum class InstructionType {
    Implied,
    Accumulator,
    Immediate,
    Zeropage,
    ZeropageX,
    ZeropageY,
    Absolute,
    AbsoluteX,
    AbsoluteY,
    Indirect,
    IndirectX,
    IndirectY,
}

class InstructionInfo(val name: String, val type: InstructionType)

