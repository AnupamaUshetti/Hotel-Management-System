import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class HotelTableModel extends AbstractTableModel {

    private String[] columnNames = {"Name", "Surname", "Date of Birth", "Role"};
    private ArrayList<HotelStaff> list;

    public HotelTableModel(ArrayList<HotelStaff> staffList) {
        list = staffList;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;
        if (columnIndex == 0) {
            temp = list.get(rowIndex).getName();
        } else if (columnIndex == 1) {
            temp = list.get(rowIndex).getSurname();
        } else if (columnIndex == 2) {
            temp = list.get(rowIndex).getDateOfBirth();
        } else if (columnIndex == 3) {
            if (list.get(rowIndex) instanceof Manager) {
                temp = "Manager";
            } else if (list.get(rowIndex) instanceof HouseKeeper) {
                temp = "HouseKeeper";
            }
        }
        return temp;
    }

    // Needed to show column names in JTable
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
}

