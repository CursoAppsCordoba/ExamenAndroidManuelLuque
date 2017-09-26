package com.example.usuario.examenandroidmanuelluque;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by usuario on 26/09/2017.
 */

public class Contactos implements Parcelable{
    private String nombre;
    private String email;
    private Integer edad;

    public Contactos(String nombre, String email, Integer edad) {
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contactos)) return false;

        Contactos contactos = (Contactos) o;

        if (getNombre() != null ? !getNombre().equals(contactos.getNombre()) : contactos.getNombre() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(contactos.getEmail()) : contactos.getEmail() != null)
            return false;
        return getEdad() != null ? getEdad().equals(contactos.getEdad()) : contactos.getEdad() == null;

    }

    @Override
    public int hashCode() {
        int result = getNombre() != null ? getNombre().hashCode() : 0;
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getEdad() != null ? getEdad().hashCode() : 0);
        return result;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    protected Contactos(Parcel in) {
        nombre = in.readString();
        email = in.readString();
        edad = in.readInt();
    }

    public static final Parcelable.Creator<Contactos> CREATOR = new Parcelable.Creator<Contactos>() {
        @Override
        public Contactos createFromParcel(Parcel in) {
            return new Contactos(in);
        }

        @Override
        public Contactos[] newArray(int size) {
            return new Contactos[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(email);
        dest.writeInt(edad);
    }

    @Override
    public String toString() {
        return nombre + " " + email + " " + edad;
    }
}
