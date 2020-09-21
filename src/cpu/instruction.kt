package cpu

class InstructionInfo(val op: UByte, val name: String, val func: (registers: Registers, memory: Memory) -> Nothing)

fun opAdc(registers: Registers, memory: Memory) { }
fun opAnd(registers: Registers, memory: Memory) { }
fun opAsl(registers: Registers, memory: Memory) { }
fun opBcc(registers: Registers, memory: Memory) { }
fun opBcs(registers: Registers, memory: Memory) { }
fun opBeq(registers: Registers, memory: Memory) { }
fun opBit(registers: Registers, memory: Memory) { }
fun opBmi(registers: Registers, memory: Memory) { }
fun opBne(registers: Registers, memory: Memory) { }
fun opBpl(registers: Registers, memory: Memory) { }
fun opBrk(registers: Registers, memory: Memory) { }
fun opBvc(registers: Registers, memory: Memory) { }
fun opBvs(registers: Registers, memory: Memory) { }
fun opClc(registers: Registers, memory: Memory) { }
fun opCld(registers: Registers, memory: Memory) { }
fun opCli(registers: Registers, memory: Memory) { }
fun opClv(registers: Registers, memory: Memory) { }
fun opCmp(registers: Registers, memory: Memory) { }
fun opCpx(registers: Registers, memory: Memory) { }
fun opCpy(registers: Registers, memory: Memory) { }
fun opDec(registers: Registers, memory: Memory) { }
fun opDex(registers: Registers, memory: Memory) { }
fun opDey(registers: Registers, memory: Memory) { }
fun opInc(registers: Registers, memory: Memory) { }
fun opInx(registers: Registers, memory: Memory) { }
fun opIny(registers: Registers, memory: Memory) { }
fun opEor(registers: Registers, memory: Memory) { }
fun opJmp(registers: Registers, memory: Memory) { }
fun opJsr(registers: Registers, memory: Memory) { }
fun opLda(registers: Registers, memory: Memory) { }
fun opLdx(registers: Registers, memory: Memory) { }
fun opLdy(registers: Registers, memory: Memory) { }
fun opLsr(registers: Registers, memory: Memory) { }
fun opNop(registers: Registers, memory: Memory) { }
fun opOra(registers: Registers, memory: Memory) { }
fun opPha(registers: Registers, memory: Memory) { }
fun opPhp(registers: Registers, memory: Memory) { }
fun opPla(registers: Registers, memory: Memory) { }
fun opPlp(registers: Registers, memory: Memory) { }
fun opRol(registers: Registers, memory: Memory) { }
fun opRor(registers: Registers, memory: Memory) { }
fun opRts(registers: Registers, memory: Memory) { }
fun opRti(registers: Registers, memory: Memory) { }
fun opSbc(registers: Registers, memory: Memory) { }
fun opSed(registers: Registers, memory: Memory) { }
fun opSei(registers: Registers, memory: Memory) { }
fun opSta(registers: Registers, memory: Memory) { }
fun opStx(registers: Registers, memory: Memory) { }
fun opSty(registers: Registers, memory: Memory) { }
fun opTax(registers: Registers, memory: Memory) { }
fun opTay(registers: Registers, memory: Memory) { }
fun opTsx(registers: Registers, memory: Memory) { }
fun opTxa(registers: Registers, memory: Memory) { }
fun opTxs(registers: Registers, memory: Memory) { }
fun opTya(registers: Registers, memory: Memory) { }

val instructions = listOf(
    ::opTax,
    ::opTay
)