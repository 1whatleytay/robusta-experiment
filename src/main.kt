fun main(args: Array<String>) {
    if (args.size != 1) {
        println("Usage: robusta path/to/rom")
    } else {
        Emulator(args[0]).run()
    }
}