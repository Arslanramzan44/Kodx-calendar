package com.kodx.calendar.models.inputs

import com.getcapacitor.PluginCall
import com.kodx.calendar.PluginError

data class DeleteCalendarInput(
    private val call: PluginCall,
) {
    val id = call.getString("id")?.toLong() ?: throw PluginError.MissingId
}
