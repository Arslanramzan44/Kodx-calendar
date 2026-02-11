package com.kodx.calendar.models.results

import com.getcapacitor.JSObject
import com.kodx.calendar.models.templates.JSResult

class CreateEventWithPromptResult : JSResult {
    override fun toJSON(): JSObject {
        val result = JSObject()
        result.put("id", null)
        return result
    }
}
