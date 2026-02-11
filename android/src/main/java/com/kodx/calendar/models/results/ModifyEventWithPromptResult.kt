package com.kodx.calendar.models.results

import com.getcapacitor.JSObject
import com.kodx.calendar.models.templates.JSResult

class ModifyEventWithPromptResult : JSResult {
    override fun toJSON(): JSObject {
        val result = JSObject()
        result.put("result", null)
        return result
    }
}
