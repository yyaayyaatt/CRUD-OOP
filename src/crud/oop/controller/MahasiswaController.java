/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.oop.controller;

import crud.oop.dao.MahasiswaDao;
import crud.oop.model.Mahasiswa;
import java.util.List;

/**
 *
 * @author yyaayyaatt
 */
public class MahasiswaController {
    private MahasiswaDao dao = new MahasiswaDao();
    
    public Mahasiswa save(Mahasiswa mahasiswa){
        return dao.save(mahasiswa);
    }
    
    public List<Mahasiswa> getAll(){
        return dao.getAll();
    }
    
    public Mahasiswa getNim(Mahasiswa mahasiswa){
        return dao.getNim(mahasiswa);
    }
    
    public Mahasiswa edit(Mahasiswa mahasiswa){
        return dao.Edit(mahasiswa);
    }
    
    public Mahasiswa hapus(Mahasiswa mahasiswa){
        return dao.hapus(mahasiswa);
    }
}
