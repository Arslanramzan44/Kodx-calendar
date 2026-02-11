package com.kodx.calendar.models.inputs

import com.getcapacitor.PluginCall
import com.kodx.calendar.PluginError
import com.kodx.calendar.models.enums.CalendarPermissionScope

data class CheckPermissionInput(
    private val call: PluginCall,
) {
    val scope: CalendarPermissionScope

    init {
        val rawScope = call.getString("scope") ?: throw PluginError.MissingScope
        scope = CalendarPermissionScope.fromValue(rawScope) ?: throw PluginError.InvalidScope

        if (scope == CalendarPermissionScope.WRITE_REMINDERS || scope == CalendarPermissionScope.READ_REMINDERS) {
            throw PluginError.InvalidScope
        }
    }
}
