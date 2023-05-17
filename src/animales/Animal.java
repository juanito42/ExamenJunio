/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animales;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public abstract class Animal {

    protected String codigo;
    private LocalDate fechaNacimiento;
    private char sexo;
    private double peso;

    /**
     * 
     * @param codigo ---> Código identificativo del animal. Tiene que ser una cadena formada por 
     * exactamente cinco caracteres alfanuméricos entre el '0' y el '9' o la 'a' y la 'z' en minúsculas
     * @param fechaNacimiento ---> Cadena conteniendo la fecha que se quiere asignar al animal 
     * como fecha de nacimiento. La cadena deberá de seguir el siguiente 
     * formato: - Un número de dos cifras que represente el día del mes.
     * Si el día solo tiene una cifra, deberá ponerse un 0 delante. 
     * Ejemplo: 01 - Un guión (-) o una barra (/) para separar el día del mes.
     * - Un número de dos cifras que represente el mes del año, entre 1 y 12.
     * Si el número del mes solo tiene una cifra, deberá ponerse un 0 delante.
     * Ejemplo: 02 para febrero - Un guión (-) o una barra (/) para separar el mes del año.
     * - Un número para representar el año
     * @param sexo ---> Sexo del animal. Será un caracter 'M' para los animales machos o 'H' para los animales hembra.
     * @param peso ---> Peso del animal en kilogramos expresado con decimales. Tiene que ser un número positivo mayor que cero.
     * @throws IllegalArgumentException ---> Si alguno de los argumentos no cumple 
     * con las condiciones establecidas para ser considerados correctos
     * 
     */
    public Animal(String codigo, String fechaNacimiento, char sexo, double peso) {

        LocalDate fecha;

        if (!codigo.matches("[0-9a-z]{5}") || (sexo != 'M' && sexo != 'H') || (peso <= 0)) {
            throw new IllegalArgumentException();
        } else {

            try {
                fecha = LocalDate.parse(fechaNacimiento);
            } catch (DateTimeParseException ex) {
                throw new IllegalArgumentException();
            }
            this.codigo = codigo;
            this.fechaNacimiento = fecha;
            this.sexo = sexo;
            this.peso = peso;
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (!codigo.matches("[0-9a-z]{5}")) {
            throw new IllegalArgumentException();
        } else {
            this.codigo = codigo;
        }
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        LocalDate fecha;

        try {
            fecha = LocalDate.parse(fechaNacimiento);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException();
        }

        this.fechaNacimiento = fecha;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        if ((sexo != 'M' && sexo != 'H')) {
            throw new IllegalArgumentException();
        } else {
            this.sexo = sexo;
        }
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.peso = peso;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.codigo);
        hash = 19 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 19 * hash + this.sexo;
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (this.sexo != other.sexo) {
            return false;
        }
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Animal{" + "codigo=" + codigo + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", peso=" + peso + '}';
    }

    public abstract String hacerSonido();

    public abstract String alegrarse();

    public abstract String enfadarse();

    public abstract String queSoy();

}
