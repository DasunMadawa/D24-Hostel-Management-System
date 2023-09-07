package bo.custom;

import bo.SuperBO;

import java.util.List;

public interface MenuBO extends SuperBO {
    public int getTotalCap() throws Exception;
    public int getActiveRes() throws Exception;
    public int getTotalFilled() throws Exception;
    public double getKeyMoneyPer() throws Exception;
    public int[] getResChart() throws Exception;

}
