package com.kodx.calendar.models.inputs

import com.getcapacitor.PluginCall
import com.kodx.calendar.PluginError
import com.kodx.calendar.utils.ImplementationHelper

data class ListEventsInRangeInput(
    private var call: PluginCall,
) {
    val from: Long =
        call.getLong("from")?.let { ImplementationHelper.getCalendarFromTimestamp(it).timeInMillis } ?: throw PluginError.FromDateMissing
    val to: Long =
        call.getLong("to")?.let { ImplementationHelper.getCalendarFromTimestamp(it).timeInMillis } ?: throw PluginError.ToDateMissing
}
