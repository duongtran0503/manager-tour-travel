/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

/**
 *
 * @author ACER
 */
import java.util.ArrayList;
public interface InterFaceDAL<T> {
     // return 200 -> thanh cong|||| return 404 -> error
    public int insert(T t);
	
	public int update(T t);
	
	public int delete(T t);
	
	public ArrayList<T> getAll();
	
	public T getById(String t);
}
