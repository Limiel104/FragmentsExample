package com.example.fragments;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String PRZEDMIOTY_TABLE = "Przedmioty";
    public static final String COLUMN_NAZWA = "nazwa";
    public static final String COLUMN_PRZEDMIOT_ID = "przedmiotID";
    public static final String COLUMN_ROK = "rok";
    public static final String COLUMN_TEMAT_ZAJEC = "temat_zajec";
    public static final String COLUMN_DATA = "data";
    public static final String COLUMN_SALA = "sala";
    public static final String COLUMN_RODZAJ_ZAJEC = "rodzaj_zajec";
    public static final String STUDENCI_TABLE = "Studenci";
    public static final String COLUMN_STUDENT_ID = "studentID";
    public static final String COLUMN_NAZWISKO = "nazwisko";
    public static final String COLUMN_IMIE = "imie";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PRZED_ID = "przedID";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "appDatabase.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        String createTableStatement = "CREATE TABLE " + PRZEDMIOTY_TABLE + " ("
                + COLUMN_PRZEDMIOT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAZWA + " TEXT, "
                + COLUMN_ROK + " INTEGER, "
                + COLUMN_TEMAT_ZAJEC + " TEXT, "
                + COLUMN_DATA + " INTEGER, "
                + COLUMN_SALA + " INTEGER, "
                + COLUMN_RODZAJ_ZAJEC + " TEXT)";
        sqLiteDatabase.execSQL(createTableStatement);

        String createTableStatement2 = "CREATE TABLE " + STUDENCI_TABLE + " ("
                + COLUMN_STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAZWISKO + " TEXT, "
                + COLUMN_IMIE + " TEXT, "
                + COLUMN_EMAIL + " TEXT, "
                + COLUMN_PRZED_ID + " INTEGER, "
                + "FOREIGN KEY (" + COLUMN_PRZED_ID + ") REFERENCES " + PRZEDMIOTY_TABLE + "(" + COLUMN_PRZEDMIOT_ID + "))";
        sqLiteDatabase.execSQL(createTableStatement2);

        ContentValues przed1 = new ContentValues();
        przed1.put(COLUMN_NAZWA, "Przedmiot1");
        przed1.put(COLUMN_ROK, 5);
        przed1.put(COLUMN_TEMAT_ZAJEC, "Gjkbskjbajkb");
        przed1.put(COLUMN_DATA, 1655916108);
        przed1.put(COLUMN_SALA, 342);
        przed1.put(COLUMN_RODZAJ_ZAJEC, "wykład");
        sqLiteDatabase.insert(PRZEDMIOTY_TABLE, null, przed1);

        ContentValues przed2 = new ContentValues();
        przed2.put(COLUMN_NAZWA, "Przedmiot2");
        przed2.put(COLUMN_ROK, 4);
        przed2.put(COLUMN_TEMAT_ZAJEC, "safsdfdg");
        przed2.put(COLUMN_DATA, 1655570508);
        przed2.put(COLUMN_SALA, 23);
        przed2.put(COLUMN_RODZAJ_ZAJEC, "ćwiczenia");
        sqLiteDatabase.insert(PRZEDMIOTY_TABLE, null, przed2);

        ContentValues przed3 = new ContentValues();
        przed3.put(COLUMN_NAZWA, "Przedmiot3");
        przed3.put(COLUMN_ROK, 4);
        przed3.put(COLUMN_TEMAT_ZAJEC, "agdfagd");
        przed3.put(COLUMN_DATA, 1654965708);
        przed3.put(COLUMN_SALA, 21);
        przed3.put(COLUMN_RODZAJ_ZAJEC, "wykład");
        sqLiteDatabase.insert(PRZEDMIOTY_TABLE, null, przed3);

        ContentValues przed4 = new ContentValues();
        przed4.put(COLUMN_NAZWA, "Przedmiot4");
        przed4.put(COLUMN_ROK, 3);
        przed4.put(COLUMN_TEMAT_ZAJEC, "adgadgadg");
        przed4.put(COLUMN_DATA, 1656434508);
        przed4.put(COLUMN_SALA, 12);
        przed4.put(COLUMN_RODZAJ_ZAJEC, "ćwiczenia");
        sqLiteDatabase.insert(PRZEDMIOTY_TABLE, null, przed4);

        ContentValues przed5 = new ContentValues();
        przed5.put(COLUMN_NAZWA, "Przedmiot5");
        przed5.put(COLUMN_ROK, 5);
        przed5.put(COLUMN_TEMAT_ZAJEC, "adfgadfga");
        przed5.put(COLUMN_DATA, 1654274508);
        przed5.put(COLUMN_SALA, 124);
        przed5.put(COLUMN_RODZAJ_ZAJEC, "ćwiczenia");
        sqLiteDatabase.insert(PRZEDMIOTY_TABLE, null, przed5);


        ContentValues stu1 = new ContentValues();
        stu1.put(COLUMN_NAZWISKO, "Kowalski");
        stu1.put(COLUMN_IMIE, "Jan");
        stu1.put(COLUMN_EMAIL, "kowal@onet.pl");
        stu1.put(COLUMN_PRZED_ID, 1);
        sqLiteDatabase.insert(STUDENCI_TABLE, null, stu1);

        ContentValues stu2 = new ContentValues();
        stu2.put(COLUMN_NAZWISKO, "Nowak");
        stu2.put(COLUMN_IMIE, "Jolanta");
        stu2.put(COLUMN_EMAIL, "nowak@wp.pl");
        stu2.put(COLUMN_PRZED_ID, 1);
        sqLiteDatabase.insert(STUDENCI_TABLE, null, stu2);

        ContentValues stu3 = new ContentValues();
        stu3.put(COLUMN_NAZWISKO, "Mazur");
        stu3.put(COLUMN_IMIE, "Agnieszka");
        stu3.put(COLUMN_EMAIL, "aga@wp.pl");
        stu3.put(COLUMN_PRZED_ID, 1);
        sqLiteDatabase.insert(STUDENCI_TABLE, null, stu3);

        ContentValues stu4 = new ContentValues();
        stu4.put(COLUMN_NAZWISKO, "Lis");
        stu4.put(COLUMN_IMIE, "Daniel");
        stu4.put(COLUMN_EMAIL, "lisdaniel@gmail.com");
        stu4.put(COLUMN_PRZED_ID, 2);
        sqLiteDatabase.insert(STUDENCI_TABLE, null, stu4);

        ContentValues stu5 = new ContentValues();
        stu5.put(COLUMN_NAZWISKO, "Stół");
        stu5.put(COLUMN_IMIE, "Tadeusz");
        stu5.put(COLUMN_EMAIL, "tadek@onet.pl");
        stu5.put(COLUMN_PRZED_ID, 2);
        sqLiteDatabase.insert(STUDENCI_TABLE, null, stu5);

        ContentValues stu6 = new ContentValues();
        stu6.put(COLUMN_NAZWISKO, "Hamak");
        stu6.put(COLUMN_IMIE, "Janina");
        stu6.put(COLUMN_EMAIL, "jhamak@gmail.com");
        stu6.put(COLUMN_PRZED_ID, 2);
        sqLiteDatabase.insert(STUDENCI_TABLE, null, stu6);

        ContentValues stu7 = new ContentValues();
        stu7.put(COLUMN_NAZWISKO, "Domagała");
        stu7.put(COLUMN_IMIE, "Aleksandra");
        stu7.put(COLUMN_EMAIL, "domagalaola@gmail.com");
        stu7.put(COLUMN_PRZED_ID, 2);
        sqLiteDatabase.insert(STUDENCI_TABLE, null, stu7);

        ContentValues stu8 = new ContentValues();
        stu8.put(COLUMN_NAZWISKO, "Kowalik");
        stu8.put(COLUMN_IMIE, "Fabian");
        stu8.put(COLUMN_EMAIL, "fabianek2@wp.pl");
        stu8.put(COLUMN_PRZED_ID, 3);
        sqLiteDatabase.insert(STUDENCI_TABLE, null, stu8);

        ContentValues stu9 = new ContentValues();
        stu9.put(COLUMN_NAZWISKO, "Gołota");
        stu9.put(COLUMN_IMIE, "Andrzej");
        stu9.put(COLUMN_EMAIL, "golotaandrzej@wp.pl");
        stu9.put(COLUMN_PRZED_ID, 3);
        sqLiteDatabase.insert(STUDENCI_TABLE, null, stu9);

        ContentValues stu10 = new ContentValues();
        stu10.put(COLUMN_NAZWISKO, "Pralka");
        stu10.put(COLUMN_IMIE, "Franciszka");
        stu10.put(COLUMN_EMAIL, "pralkafranka@onet.pl");
        stu10.put(COLUMN_PRZED_ID, 4);
        sqLiteDatabase.insert(STUDENCI_TABLE, null, stu10);

        ContentValues stu11 = new ContentValues();
        stu11.put(COLUMN_NAZWISKO, "Rower");
        stu11.put(COLUMN_IMIE, "Robert");
        stu11.put(COLUMN_EMAIL, "robert@onet.pl");
        stu11.put(COLUMN_PRZED_ID, 3);
        sqLiteDatabase.insert(STUDENCI_TABLE, null, stu11);

        ContentValues stu12 = new ContentValues();
        stu12.put(COLUMN_NAZWISKO, "Warszawski");
        stu12.put(COLUMN_IMIE, "Bartosz");
        stu12.put(COLUMN_EMAIL, "warszawskibartosz423@gmail.com");
        stu12.put(COLUMN_PRZED_ID, 3);
        sqLiteDatabase.insert(STUDENCI_TABLE, null, stu12);

        ContentValues stu13 = new ContentValues();
        stu13.put(COLUMN_NAZWISKO, "Zawisza");
        stu13.put(COLUMN_IMIE, "Czesław");
        stu13.put(COLUMN_EMAIL, "zawisza12@onet.pl");
        stu13.put(COLUMN_PRZED_ID, 2);
        sqLiteDatabase.insert(STUDENCI_TABLE, null, stu13);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addPrzedmiot(Przedmiot przedmiot) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAZWA, przedmiot.getNazwa());
        cv.put(COLUMN_ROK, przedmiot.getRok());
        cv.put(COLUMN_TEMAT_ZAJEC, przedmiot.getTematZajec());
        cv.put(COLUMN_DATA, przedmiot.getData());
        cv.put(COLUMN_SALA, przedmiot.getSala());
        cv.put(COLUMN_RODZAJ_ZAJEC, przedmiot.getRodzajZajec());

        db.insert(PRZEDMIOTY_TABLE, null, cv);
    }

    public ArrayList<Przedmiot> getAllPrzedmiots() {

        ArrayList<Przedmiot> returnAList = new ArrayList<>();

        String queryString = "SELECT * FROM " + PRZEDMIOTY_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do{
                int przedmiotID = cursor.getInt(0);
                String nazwa = cursor.getString(1);
                int rok = cursor.getInt(2);
                String tematZajec = cursor.getString(3);
                int data = cursor.getInt(4);
                int sala = cursor.getInt(5);
                String rodzajZajec = cursor.getString(6);

                Przedmiot newPrzedmiot = new Przedmiot(przedmiotID, nazwa, rok, tematZajec, data, sala, rodzajZajec);
                returnAList.add(newPrzedmiot);

            }while (cursor.moveToNext());
        }else {

        }

        cursor.close();
        db.close();
        return returnAList;
    }

    public Przedmiot findPrzedmiot(int przedmiotID) {

        String queryString = "SELECT * FROM " + PRZEDMIOTY_TABLE + " WHERE " + COLUMN_PRZEDMIOT_ID + "=" + przedmiotID;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            String nazwa = cursor.getString(1);
            int rok = cursor.getInt(2);
            String tematZajec = cursor.getString(3);
            int data = cursor.getInt(4);
            int sala = cursor.getInt(5);
            String rodzajZajec = cursor.getString(6);
            Przedmiot returnPrzedmiot = new Przedmiot(przedmiotID, nazwa, rok, tematZajec, data, sala, rodzajZajec);cursor.close();
            db.close();
            return returnPrzedmiot;
        }else {
            cursor.close();
            db.close();
            return null;
        }
    }

    public boolean updatePrzedmiot(Przedmiot przedmiot) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAZWA, przedmiot.getNazwa());
        contentValues.put(COLUMN_ROK, przedmiot.getRok());
        contentValues.put(COLUMN_TEMAT_ZAJEC, przedmiot.getTematZajec());
        contentValues.put(COLUMN_DATA, przedmiot.getData());
        contentValues.put(COLUMN_SALA, przedmiot.getSala());
        contentValues.put(COLUMN_RODZAJ_ZAJEC, przedmiot.getRodzajZajec());

        String[] przedmiotID = new String[]{String.valueOf(przedmiot.getPrzedmiotID())};

        long update = db.update(PRZEDMIOTY_TABLE, contentValues,   COLUMN_PRZEDMIOT_ID + " = ? ", przedmiotID);

        if (update == -1)
            return false;
        else
            return true;
    }

    public boolean deletePrzedmiot(Przedmiot przedmiot) {

        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + PRZEDMIOTY_TABLE + " WHERE " + COLUMN_PRZEDMIOT_ID + " = " + przedmiot.getPrzedmiotID();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            ArrayList<Student> arrayList = getAllStudentsFromPrzedmiot(przedmiot.przedmiotID);

            if (!arrayList.isEmpty()) {
                deleteAllStudentsFromPrzedmiot(arrayList);
            }
            return true;
        }else{
            return false;
        }
    }

    public void addStudent(Student student) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAZWISKO, student.getNazwisko());
        cv.put(COLUMN_IMIE, student.getImie());
        cv.put(COLUMN_EMAIL, student.getEmail());
        cv.put(COLUMN_PRZED_ID, student.getPrzedID());

        db.insert(STUDENCI_TABLE, null, cv);
    }

    public ArrayList<Student> getAllStudents() {

        ArrayList<Student> returnAList = new ArrayList<>();

        String queryString = "SELECT * FROM " + STUDENCI_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do{
                int studentID = cursor.getInt(0);
                String  nazwisko = cursor.getString(1);
                String  imie = cursor.getString(2);
                String  email = cursor.getString(3);
                int przedID = cursor.getInt(4);

                Student newStudent = new Student(studentID, nazwisko, imie, email, przedID);
                returnAList.add(newStudent);

            }while (cursor.moveToNext());
        }else {

        }

        cursor.close();
        db.close();
        return returnAList;
    }

    public ArrayList<Student> getAllStudentsFromPrzedmiot(int przedmiotID) {

        ArrayList<Student> returnAList = new ArrayList<>();

        String queryString = "SELECT * FROM " + STUDENCI_TABLE+ " WHERE " + COLUMN_PRZED_ID + " = " + przedmiotID;;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do{
                int studentID = cursor.getInt(0);
                String  nazwisko = cursor.getString(1);
                String  imie = cursor.getString(2);
                String  email = cursor.getString(3);
                int przedID = cursor.getInt(4);

                Student newStudent = new Student(studentID, nazwisko, imie, email, przedID);
                returnAList.add(newStudent);

            }while (cursor.moveToNext());
        }else {

        }

        cursor.close();
        db.close();
        return returnAList;
    }

    public Student findStudent(int studentID) {

        String queryString = "SELECT * FROM " + STUDENCI_TABLE + " WHERE " + COLUMN_STUDENT_ID + "=" + studentID;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            String nazwisko = cursor.getString(1);
            String imie = cursor.getString(2);
            String email = cursor.getString(3);
            int przedID = cursor.getInt(4);
            Student returnStudent = new Student(studentID, nazwisko, imie, email, przedID);
            cursor.close();
            db.close();
            return returnStudent;
        }else {
            cursor.close();
            db.close();
            return null;
        }
    }

    public boolean updateStudent(Student student) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAZWISKO, student.getNazwisko());
        contentValues.put(COLUMN_IMIE, student.getImie());
        contentValues.put(COLUMN_EMAIL, student.getEmail());
        contentValues.put(COLUMN_PRZED_ID, student.getPrzedID());

        String[] studentID = new String[]{String.valueOf(student.getStudentID())};

        long update = db.update(STUDENCI_TABLE, contentValues,   COLUMN_STUDENT_ID + " = ? ", studentID);

        if (update == -1)
            return false;
        else
            return true;
    }

    public boolean deleteStudent(Student student) {

        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + STUDENCI_TABLE + " WHERE " + COLUMN_STUDENT_ID + " = " + student.getStudentID();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            return true;
        }else{
            return false;
        }
    }

    public void deleteAllStudentsFromPrzedmiot(ArrayList<Student> students) {

        SQLiteDatabase db = this.getWritableDatabase();

        for (int i = 0; i < students.size(); i++) {
            String queryString = "DELETE FROM " + STUDENCI_TABLE + " WHERE " + COLUMN_STUDENT_ID + " = " + students.get(i).getStudentID();
            Cursor cursor = db.rawQuery(queryString, null);

            if (cursor.moveToFirst()) {
            }
            else {
            }
        }
    }








}
