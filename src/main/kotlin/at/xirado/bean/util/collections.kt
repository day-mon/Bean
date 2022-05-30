package at.xirado.bean.util

import java.util.*

inline fun <reified T: Enum<T>> emptyEnumSet() = EnumSet.noneOf(T::class.java)
inline fun <reified T: Enum<T>> enumSetOf(vararg elements: T) = EnumSet.copyOf(elements.toList())
inline fun <reified T: Enum<T>> enumSetOf(elements: Collection<T>) = EnumSet.copyOf(elements)
inline fun <reified T: Enum<T>> Iterable<T>.toEnumSet(): EnumSet<T> {
    if (this is Collection) {
        return when (size) {
            0 -> emptyEnumSet<T>()
            else -> enumSetOf(this)
        }
    }
    return emptyEnumSet()
}
