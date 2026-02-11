package com.kodx.calendar.models.inputs

import com.getcapacitor.PluginCall
import com.kodx.calendar.PluginError
import com.kodx.calendar.utils.ImplementationHelper

data class DeleteEventsByIdInput(
    private val call: PluginCall,
) {
    var ids = call.getArray("ids")?.let { ImplementationHelper.jsArrayToLongArray(it) } ?: throw PluginError.MissingId
}
