@Entity(tableName = "farms", foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "id",
        childColumns = "userId",
        onDelete = ForeignKey.CASCADE))
public class Farm {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int userId;
    public String name;
}
