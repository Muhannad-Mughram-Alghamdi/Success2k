package sa.edu.tuwaiq.fockos.until

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
//@Abdullah Alfaraj, Abdulaziz Alrajeh

class DateUtilTest{

    private lateinit var dateUtil:DateUtil

    @Before
    fun setUp(){
        dateUtil = DateUtil()

    }

    @Test
    fun convertTimeStampYYMMDDToCheckIfDateThatReturnCorrectFormattedDate(){
        val checker = dateUtil.convertTimeStampYYMMDD("1638132304")
         assertEquals("1970/01/20",checker)


    }
    @Test
    fun convertTimeStampYYMMDDToCheckIfDateThatReturnWrongFormattedDate(){
        val checker = dateUtil.convertTimeStampYYMMDD("1638132304")
        assertEquals("1970/04/20",checker)


    }
    @Test
    fun convertTimeStampEEEMMYYYYToCheckIfDateThatReturnsCorrectFormatted(){
        val checker = dateUtil.convertTimeStampEEEMMYYYY("1638132304")
        assertEquals("Tue,20,1970",checker)


    }
    @Test
    fun convertTimeStampEEEMMYYYYToCheckIfDateThatReturnsWrongFormatted(){
        val checker = dateUtil.convertTimeStampEEEMMYYYY("1638132304")
        assertEquals("Tue,20,1870",checker)


    }
    @Test
    fun convertDataUsing_YY_MM_DDToCheckDateIsFormattedThatReturnCorrectValue(){
        val checker = dateUtil.convertDataUsing_YY_MM_dd_("2021-11-27")
        assertEquals("2021/11/27",checker)
    }
    @Test
    fun convertDataUsing_YY_MM_DDToCheckDateIsFormattedThatReturnWrongValue(){
        val checker = dateUtil.convertDataUsing_YY_MM_dd_("2021-11-27")
        assertEquals("2021-11/27",checker)
    }

}