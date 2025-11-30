package com.example.pdm_roteiro_pratico_14
// Arquivo: DatabaseHelper.kt
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "TarefasDB", null, 1) {

    companion object {
        const val TABLE_NAME = "tarefas"
        const val COL_ID = "id"
        const val COL_DESC = "descricao"
        const val COL_RESP = "responsavel"
        const val COL_STATUS = "status"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """
            CREATE TABLE $TABLE_NAME (
                $COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COL_DESC TEXT,
                $COL_RESP TEXT,
                $COL_STATUS INTEGER
            )
        """.trimIndent()
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    // 1. Inserir
    fun inserirTarefa(tarefa: Tarefa): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COL_DESC, tarefa.descricao)
            put(COL_RESP, tarefa.responsavel)
            put(COL_STATUS, tarefa.status)
        }
        val result = db.insert(TABLE_NAME, null, values)
        db.close()
        return result
    }

    // 2. Listar
    fun listarTarefas(): ArrayList<Tarefa> {
        val lista = ArrayList<Tarefa>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow(COL_ID))
                val desc = cursor.getString(cursor.getColumnIndexOrThrow(COL_DESC))
                val resp = cursor.getString(cursor.getColumnIndexOrThrow(COL_RESP))
                val status = cursor.getInt(cursor.getColumnIndexOrThrow(COL_STATUS))
                lista.add(Tarefa(id, desc, resp, status))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return lista
    }

    fun atualizarTarefa(tarefa: Tarefa): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COL_DESC, tarefa.descricao)
            put(COL_RESP, tarefa.responsavel)
            put(COL_STATUS, tarefa.status)
        }
        val rows = db.update(TABLE_NAME, values, "$COL_ID = ?", arrayOf(tarefa.id.toString()))
        db.close()
        return rows
    }

    fun deletarTarefa(id: Int): Int {
        val db = writableDatabase
        val rows = db.delete(TABLE_NAME, "$COL_ID = ?", arrayOf(id.toString()))
        db.close()
        return rows
    }
}