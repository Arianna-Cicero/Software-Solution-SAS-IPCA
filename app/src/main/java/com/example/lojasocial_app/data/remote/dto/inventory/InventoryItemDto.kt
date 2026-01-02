data class InventoryItemDto(
    val id_good: Int,
    val name: String,
    val category: String,
    val quantity: Int,
    val intake_date: String,
    val valid_until: String,
    val status: String,
    val has_alert: Boolean
)