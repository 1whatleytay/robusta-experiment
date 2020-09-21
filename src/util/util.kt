package util

typealias Address = UShort;

fun kb(num: Int) = num * 1024

fun hi(value: UShort) = value.toInt().shr(8).and(0xFF).toUByte()
fun lo(value: UShort) = value.toInt().and(0xFF).toUByte()
fun make(a: UByte, b: UByte) = b.toInt().shl(8).or(a.toInt()).toUShort()
