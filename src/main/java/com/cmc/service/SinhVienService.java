package com.cmc.service;
import java.util.List;

import com.cmc.entity.SinhVien;;


 /**
 * Create by: NV Tiep
 * Create date:Oct 26, 2018
 * Modifier: NV Tiep
 * Modified date: Oct 26, 2018
 * Description:Các phương thức thao tác với reposity
 */
public interface SinhVienService {
	
   /**
 * Create by: NV Tiep
 * Create date:Oct 26, 2018
 * Modifier: NV Tiep
 * Modified date: Oct 26, 2018
 * Description:Lấy danh sách sinh viên
 * Version 1.0
 * @return trả về danh sách sinh viên
 */
  List<SinhVien> getdAll();
  boolean insert(SinhVien s);
  boolean update(SinhVien s);
  boolean delete(String s);
  List<SinhVien> search(String s);
}
