package fjdbc;

public interface FedResultSetInterface {

	public boolean next() throws FedException;

	public String getString(int columnIndex) throws FedException;

	public int getInt(int columnIndex) throws FedException;

	public int getColumnCount() throws FedException;

	public String getColumnName(int index) throws FedException;

	public String getColumnType(int index) throws FedException;

	public void close() throws FedException;

}
