package controller;


import com.itextpdf.barcodes.BarcodeCodabar;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Necil Dabre, Preet Dabre, Glen Dabre, Chris Carvalho
 */
public class GenerateReport {
    private static PdfWriter writer;
    private static PdfDocument pdf;
    private static Document doc;
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static String sql;
    
  
    public static boolean generateBookReport(Connection con){
            try {
                con = DataBaseConnection.getConnection();
                rs = null;
                 writer = new PdfWriter("BookReport.pdf");
                 pdf = new PdfDocument(writer);
                 doc = new Document(pdf,new PageSize(900,900));
                 Table table = new Table(9, true);
                 sql="select bookid as Id, bookname as Name,isbn as ISBN, edition as Edition, authorname as Author, catid as Category, nop as No_of_Pages,shelfno as Shelf, avialable as Available from books";
                 ps = con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 ResultSetMetaData rsmd = rs.getMetaData();
                 if(rs != null){
                     for (int i = 1; i <= 9; i++) {                         
                        table.addHeaderCell(new Cell().setTextAlignment(TextAlignment.CENTER).add(new Paragraph("" + rsmd.getColumnLabel(i))));
                    }
                    doc.add(table);
                     while(rs.next()){
                         for (int i = 1; i <= 9; i++) {
                            if(i == 7){
                                table.addCell(new Cell().add(new Paragraph("" + rs.getInt(i)).setMargins(0, 0, 0, 0)));
                            }
                            else{
                                table.addCell(new Cell().add(new Paragraph("" + rs.getString(i)).setMargins(0, 0, 0, 0)));
                            }
                         }
                         table.flush();
                     }
                 }
 
            table.complete();
 
        doc.close();
        return true;
        } catch (Exception e) {
                System.out.println(""+e);
        }
        return false;
    }
    
    public static boolean generateMemberReport(Connection con){
        try {
                con = DataBaseConnection.getConnection();
                 writer = new PdfWriter("MemberReport.pdf");
                 pdf = new PdfDocument(writer);
                 doc = new Document(pdf,new PageSize(900,900));
                 float[] columnWidths = {1, 5, 5,5,5};
                 Table table = new Table(columnWidths, true);
                 table.setWidthPercent(100);
                 sql="SELECT memid as ID, memname as Name, memadd as Address, mememail as Email, password as Password FROM members";
                 ps = con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 ResultSetMetaData rsmd = rs.getMetaData();
                 if(rs != null){
                     for (int i = 1; i <= 5; i++) {                         
                        table.addHeaderCell(new Cell().setTextAlignment(TextAlignment.CENTER).add(new Paragraph("" + rsmd.getColumnLabel(i))));
                    }
                    doc.add(table);
                     while(rs.next()){
                         for (int i = 1; i <= 5; i++) {
                            if(i == 1){
                                table.addCell(new Cell().add(new Paragraph("" + rs.getInt(i)).setMargins(0, 0, 0, 0)));
                            }
                            else{
                                table.addCell(new Cell().add(new Paragraph("" + rs.getString(i)).setMargins(0, 0, 0, 0)));
                            }
                         }
                         table.flush();
                     }
                 }
 
            table.complete();
        doc.close();
        return true;
        } catch (Exception e) {
                System.out.println(""+e);
        }
        return false;
    }
    
    public static boolean generateBorrowDetails(Connection con){
        try {
                con = DataBaseConnection.getConnection();
                 writer = new PdfWriter("IssuseReport.pdf");
                 pdf = new PdfDocument(writer);
                 doc = new Document(pdf,new PageSize(900,900));
                 float[] columnWidths = {2, 5,5, 3,5,5,5};
                 Table table = new Table(columnWidths, true);
                 table.setWidthPercent(100);
                 sql="SELECT bid AS IssuseId, b.bookid AS BookID, b.bookname AS BookName,bb.memid as MemberId,mem.memname as MemberName , issusedate as IssusedDate, returndate as ReturnDate FROM books_borrowed AS bb, books AS b, members AS mem WHERE bb.bookid = b.bookid and mem.memid = bb.memid";
                 ps = con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 ResultSetMetaData rsmd = rs.getMetaData();
                 if(rs != null){
                     for (int i = 1; i <= 7; i++) {                         
                        table.addHeaderCell(new Cell().setTextAlignment(TextAlignment.CENTER).add(new Paragraph("" + rsmd.getColumnLabel(i))));
                    }
                    doc.add(table);
                     while(rs.next()){
                         for (int i = 1; i <= 7; i++) {
                            if(i == 1){
                                table.addCell(new Cell().add(new Paragraph("" + rs.getInt(i)).setMargins(0, 0, 0, 0)));
                            }
                            else{
                                table.addCell(new Cell().add(new Paragraph("" + rs.getString(i)).setMargins(0, 0, 0, 0)));
                            }
                         }
                         table.flush();
                     }
                 }
 
            table.complete();
        doc.close();
        return true;
        } catch (Exception e) {
                System.out.println(""+e);
        }
        return false;
        
    }
    public static boolean generateMemberReport(Connection con,String memid){
        try {
                con = DataBaseConnection.getConnection();
                 writer = new PdfWriter("MemberID"+memid+"Report.pdf");
                 pdf = new PdfDocument(writer);
                 doc = new Document(pdf,PageSize.A4);
                 
                 sql = "select * from members where memid = ?";
                 ps =con.prepareStatement(sql);
                 ps.setString(1, memid);
                 rs = ps.executeQuery();
                 if(rs.next()){
                     doc.add(new Paragraph("Member Name : "+rs.getString("memname")));
                     doc.add(new Paragraph("Member Id : "+rs.getInt("memid")));
                     doc.add(new Paragraph("Address : "+rs.getString("memadd")));
                     doc.add(new Paragraph("Email : "+rs.getString("mememail")));
                     doc.add(new Paragraph(" "));
                 }
                 else{
                     doc.close();
                     return false;
                 }
                 
                 doc.add(new Paragraph("Books Issused"));
                 float[] columnWidths = {3,4,5,5,5};
                 Table table = new Table(columnWidths, true);
                 table.setWidthPercent(100);
                 sql="SELECT bid AS IssuseId, b.bookid AS BookID, b.bookname AS BookName,issusedate as IssusedDate, returndate as ReturnDate FROM books_borrowed AS bb, books AS b, members AS mem WHERE bb.bookid = b.bookid and mem.memid = bb.memid and bb.memid like ?";
                 ps = con.prepareStatement(sql);
                 ps.setString(1, memid);
                 rs = ps.executeQuery();
                 ResultSetMetaData rsmd = rs.getMetaData();
                 if(rs != null){
                     for (int i = 1; i <= 5; i++) {                         
                        table.addHeaderCell(new Cell().setTextAlignment(TextAlignment.CENTER).add(new Paragraph("" + rsmd.getColumnLabel(i))));
                    }
                    doc.add(table);
                     while(rs.next()){
                         for (int i = 1; i <= 5; i++) {
                            if(i == 1){
                                table.addCell(new Cell().add(new Paragraph("" + rs.getInt(i)).setMargins(0, 0, 0, 0)));
                            }
                            else{
                                table.addCell(new Cell().add(new Paragraph("" + rs.getString(i)).setMargins(0, 0, 0, 0)));
                            }
                         }
                         table.flush();
                     }
                 }
                 else{
                     doc.add(new Paragraph("No Books Issused"));
                 }
            table.complete();
        doc.close();
        return true;
        } catch (Exception e) {
                System.out.println(""+e);
        }
        
        return false;
    }
    
    public static boolean generateBarcode(Connection con){
        try {
                con = DataBaseConnection.getConnection();
                 writer = new PdfWriter("BarcodeBooklet.pdf");
                 pdf = new PdfDocument(writer);
                 doc = new Document(pdf,PageSize.A4);
                 
                 float[] columnWidths = {3,3,3,7};
                 Table table = new Table(columnWidths, true);
                 table.setWidthPercent(100);
                 
                 sql = "select bookid,bookname,edition from books ";
                 ps =con.prepareStatement(sql);
                 rs = ps.executeQuery();
                 ResultSetMetaData rsmd = rs.getMetaData();
                 if(rs != null){
                     for (int i = 1; i <= 4; i++) {   
                         if(i==4){
                             table.addHeaderCell(new Cell().setTextAlignment(TextAlignment.CENTER).add(new Paragraph("Barcode ")));
                             continue;
                         }
                        table.addHeaderCell(new Cell().setTextAlignment(TextAlignment.CENTER).add(new Paragraph("" + rsmd.getColumnLabel(i))));
                    }
                    doc.add(table);
                     while(rs.next()){
                         for (int i = 1; i <= 4; i++) {
                            if(i == 4){
                                table.addCell(createBarcode(rs.getString(1), pdf).setMargins(0,0,0,0));
                            }
                            else{
                                table.addCell(new Cell().add(new Paragraph("" + rs.getString(i)).setMargins(0, 0, 0, 0)));
                            }
                         }
                         table.flush();
                     }
                 }
                 else{
                     doc.add(new Paragraph("No Books Issused"));
                 }
            table.complete();
        doc.close();
        return true;
        } catch (Exception e) {
                System.out.println(""+e);
        }
        
        return true;
    } 
        
    public static Cell createBarcode(String code, PdfDocument pdfDoc) {
        //BarcodeEAN barcode = new BarcodeEAN(pdfDoc);
        BarcodeCodabar barcode = new BarcodeCodabar(pdfDoc);
        //barcode.setCodeType(BarcodeEAN.UPCA);
        barcode.setCode("A"+code+"D");
        Cell cell = new Cell().add(new Image(barcode.createFormXObject(null, null, pdfDoc)).scale(1.50f, 1.50f));
        cell.setPaddingTop(10);
        cell.setPaddingRight(10);
        cell.setPaddingBottom(10);
        cell.setPaddingLeft(10);
        return cell;
    }
    public static boolean generateAllMemberReport(Connection con){
        
        try {
                con = DataBaseConnection.getConnection();
                 writer = new PdfWriter("MemberReport.pdf");
                 pdf = new PdfDocument(writer);
                 doc = new Document(pdf,new PageSize(600,500));
                 
                 sql = "select * from members";
                 ps =con.prepareStatement(sql);
                 ResultSet rs1 = ps.executeQuery();
                 
                 while(rs1.next()){
                     float[] infocolumn = {3,7};
                    Table infotable = new Table(infocolumn, true);
                    infotable.setWidthPercent(70);
                    
                    doc.add(infotable);
                    infotable.addCell(new Cell().add(new Paragraph("Member Id")));
                    infotable.addCell(new Cell().add(new Paragraph("" + rs1.getInt("memid"))));
                    
                    infotable.addCell(new Cell().add(new Paragraph("Member Name")));
                    infotable.addCell(new Cell().add(new Paragraph("" + rs1.getString("memname")).setMargins(0, 0, 0, 0)));
                    
                    infotable.addCell(new Cell().add(new Paragraph("Address")));
                    infotable.addCell(new Cell().add(new Paragraph("" + rs1.getString("memadd"))));
                    
                    infotable.addCell(new Cell().add(new Paragraph("Email").setMargins(0, 0, 0, 0)));
                    infotable.addCell(new Cell().add(new Paragraph("" + rs1.getString("mememail"))));
                    
                    
                    infotable.flush();
                    infotable.complete();
                    doc.add(new Paragraph(" "));
                     String memid = ""+rs1.getInt("memid");
                 
                            doc.add(new Paragraph("Books Issused").setFontSize(24).setTextAlignment(TextAlignment.CENTER));
                            
                            sql="SELECT bid AS IssuseId, b.bookid AS BookID, b.bookname AS BookName,issusedate as IssusedDate, returndate as ReturnDate FROM books_borrowed AS bb, books AS b, members AS mem WHERE bb.bookid = b.bookid and mem.memid = bb.memid and bb.memid like ?";
                            ps = con.prepareStatement(sql);
                            ps.setString(1, memid);
                            rs = ps.executeQuery();
                            ResultSetMetaData rsmd = rs.getMetaData();
                            if(rs.isBeforeFirst()){
                                float[] columnWidths = {3,4,5,5,5};
                                Table table = new Table(columnWidths, true);
                                table.setWidthPercent(100);
                                for (int i = 1; i <= 5; i++) {                         
                                   table.addHeaderCell(new Cell().setTextAlignment(TextAlignment.CENTER).add(new Paragraph("" + rsmd.getColumnLabel(i))));
                               }
                               doc.add(table);
                                while(rs.next()){
                                    for (int i = 1; i <= 5; i++) {
                                       if(i == 1){
                                           table.addCell(new Cell().add(new Paragraph("" + rs.getInt(i)).setMargins(0, 0, 0, 0)));
                                       }
                                       else{
                                           table.addCell(new Cell().add(new Paragraph("" + rs.getString(i)).setMargins(0, 0, 0, 0)));
                                       }
                                    }
                                    table.flush();
                                }
                                table.complete();
                            }
                            else{
                                doc.add(new Paragraph("No Books Issused").setTextAlignment(TextAlignment.CENTER));
                            }
                        doc.add(new AreaBreak());
            }//end of while
        doc.close();
        
        return true;
        } catch (Exception e) {
                System.err.println(""+e);
        }
        
        return false;
    }
}
