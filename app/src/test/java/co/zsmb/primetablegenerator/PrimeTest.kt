package co.zsmb.primetablegenerator

import org.junit.Test

import org.junit.Assert.*

class PrimeTest {
    @Test
    fun `isPrime is correct`() {
        assertEquals(false, 0.isPrime())
        assertEquals(false, 1.isPrime())
        assertEquals(true, 2.isPrime())
        assertEquals(true, 3.isPrime())
        assertEquals(false, 4.isPrime())

        assertEquals(false, 10.isPrime())
        assertEquals(true, 11.isPrime())
        assertEquals(false, 12.isPrime())
        assertEquals(true, 13.isPrime())
        assertEquals(false, 14.isPrime())

        assertEquals(false, 20.isPrime())
        assertEquals(false, 21.isPrime())
        assertEquals(false, 22.isPrime())
        assertEquals(true, 23.isPrime())
        assertEquals(false, 24.isPrime())
    }
}
