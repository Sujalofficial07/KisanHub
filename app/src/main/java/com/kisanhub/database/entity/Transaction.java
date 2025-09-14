@Entity(tableName = "transactions", foreignKeys = @ForeignKey(entity = Farm.class,
        parentColumns = "id",
        childColumns = "farmId",
        onDelete = ForeignKey.CASCADE))
public class Transaction {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int farmId;
    public double amount;
    public String description;
    public String category; // e.g., Seeds, Labour, etc.
    public String type;     // "income" or "expense"
    public long date;       // Timestamp
}
