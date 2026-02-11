package com.kodx.calendar.models.results

import com.getcapacitor.JSObject
import com.getcapacitor.PermissionState
import com.getcapacitor.PluginCall
import com.kodx.calendar.PluginError
import com.kodx.calendar.models.enums.CalendarPermissionScope
import com.kodx.calendar.models.inputs.RequestPermissionInput
import com.kodx.calendar.models.templates.JSResult

sealed class RequestPermissionResult : JSResult {
    abstract val state: PermissionState
    protected abstract val getPermissionState: (String) -> PermissionState?

    data class FromCall(
        val call: PluginCall,
        override val getPermissionState: (String) -> PermissionState?,
    ) : RequestPermissionResult() {
        private val input = RequestPermissionInput.FromCall(call, "")
        override val state = getPermissionState(input.scope.value) ?: throw PluginError.UnhandledPermissionState
    }

    data class FromScope(
        val scope: CalendarPermissionScope,
        override val getPermissionState: (String) -> PermissionState?,
    ) : RequestPermissionResult() {
        override val state = getPermissionState(scope.value) ?: throw PluginError.UnhandledPermissionState
    }

    data class FullCalendarAccess(
        override val getPermissionState: (String) -> PermissionState?,
    ) : RequestPermissionResult() {
        private val scope = "readWriteCalendar"
        override val state = getPermissionState(scope) ?: throw PluginError.UnhandledPermissionState
    }

    override fun toJSON(): JSObject {
        val result = JSObject()
        result.put("result", state.toString())
        return result
    }
}
