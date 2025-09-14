@Dao
public interface FarmDao {
    @Insert
    void insert(Farm farm);

    @Update
    void update(Farm farm);

    @Delete
    void delete(Farm farm);
    
    @Query("SELECT COUNT(*) FROM farms WHERE userId = :userId")
    LiveData<Integer> getFarmCountForUser(int userId);

    @Query("SELECT * FROM farms WHERE userId = :userId ORDER BY name ASC")
    LiveData<List<Farm>> getFarmsForUser(int userId);
}
