package com.seidko.phocam.data.entities

/**
 * Connection data entity
 */
class Connection (
    val type: ConnectionType,
    var name: String,
    ) {
    var status = ConnectionStatus.InActive
    var address: String = when (type) {
        ConnectionType.USB -> "USB"
        ConnectionType.WiFi -> "0.0.0.0"
        ConnectionType.Bluetooth -> "Bluetooth"
    }

}

enum class ConnectionType {
    USB, WiFi, Bluetooth
}

enum class ConnectionStatus {
    InActive, Connecting, Active
}