package com.kodx.calendar.models.inputs

import com.getcapacitor.PluginCall
import com.kodx.calendar.utils.ImplementationHelper

data class OpenCalendarInput(
    private val call: PluginCall,
) {
    val date: Long = ImplementationHelper.getCalendarFromTimestamp(call.getLong("date")).timeInMillis
}
