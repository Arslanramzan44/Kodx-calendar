package com.kodx.calendar.models.results

import com.getcapacitor.JSObject
import com.getcapacitor.PermissionState
import com.kodx.calendar.models.enums.CalendarPermissionScope
import com.kodx.calendar.models.templates.JSResult

data class CheckAllPermissionsResult(
    val permissionStates: Map<CalendarPermissionScope, PermissionState>,
) : JSResult {
    override fun toJSON(): JSObject {
        val result = JSObject()
        permissionStates.forEach { (scope, state) -> result.put(scope.value, state.toString()) }
        result.put("result", permissionStates)
        return result
    }
}
