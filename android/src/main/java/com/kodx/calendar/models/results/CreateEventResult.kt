package com.kodx.calendar.models.results

import com.getcapacitor.JSObject
import com.kodx.calendar.PluginError
import com.kodx.calendar.models.templates.JSResult

data class CreateEventResult(
    val id: Long?,
) : JSResult {
    init {
        if (id == null) {
            throw PluginError.FailedToRetrieveEventId
        }
    }

    override fun toJSON(): JSObject {
        val result = JSObject()
        result.put("id", id.toString())
        return result
    }
}
