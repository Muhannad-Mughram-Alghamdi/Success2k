package sa.edu.tuwaiq.fockos.until

import org.junit.Assert
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
        Assert.assertThrows(Exception::class.java) {
            dateUtil.convertTimeStampYYMMDD("dfsfgdfg")

        }



    }


    @Test
    fun convertTimeStampEEEMMYYYYToCheckIfDateThatReturnsCorrectFormatted(){
        val checker = dateUtil.convertTimeStampEEEMMYYYY("1638132304")
        assertEquals("Tue,20,1970",checker)


    }

    @Test
    fun convertTimeStampEEEMMYYYYInValidToCheckIfDateThatReturnsFormatted(){

        Assert.assertThrows(Exception::class.java) {
            dateUtil.convertTimeStampEEEMMYYYY("sdfsdfsdd")
        }

    }





}