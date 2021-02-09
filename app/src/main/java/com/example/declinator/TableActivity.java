package com.example.declinator;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class TableActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TextView nomSing, nomPl, genSing, genPl, datSing, datPl, acuSing, acuPl, instSing, instPl, prepSing, prepPl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        nomSing = (TextView)findViewById(R.id.tv_nomSing);
        nomPl = (TextView)findViewById(R.id.tv_nomPl);
        genSing = (TextView)findViewById(R.id.tv_genSing);
        genPl = (TextView)findViewById(R.id.tv_genPl);
        datSing = (TextView)findViewById(R.id.tv_datSing);
        datPl = (TextView)findViewById(R.id.tv_datPl);
        acuSing = (TextView)findViewById(R.id.tv_acuSing);
        acuPl = (TextView)findViewById(R.id.tv_acuPl);
        instSing = (TextView)findViewById(R.id.tv_instSing);
        instPl = (TextView)findViewById(R.id.tv_instPl);
        prepSing = (TextView)findViewById(R.id.tv_prepSing);
        prepPl = (TextView)findViewById(R.id.tv_prepPl);

        String palabra = getIntent().getStringExtra("palabra").toLowerCase().trim();
        boolean generoF = getIntent().getBooleanExtra("generoF", true);
        boolean generoM = getIntent().getBooleanExtra("generoM", false);
        boolean generoN = getIntent().getBooleanExtra("generoN", false);
        boolean animadoS = getIntent().getBooleanExtra("animadoS", true);
        boolean animadoN = getIntent().getBooleanExtra("animadoN", false);

        //Elegimos género y si es animada
        if(generoF && animadoS) {
            femeninoAnimado(palabra);

        } else if(generoM && animadoS) {
            masculinoAnimado(palabra);

        } else if(generoF && animadoN){
            femeninoInanimado(palabra);

        } else if(generoM && animadoN) {
            masculinoInanimado(palabra);

        } else if(generoN) {
            neutro(palabra);

        }

    }


    //Transformar lista de caracteres a String ------------------------------------------------------
    public String charListAString(ArrayList<Character> lista) {
        StringBuilder auxPalabra = new StringBuilder();
        for (Character ch: lista) {
            auxPalabra.append(ch);
        }

        return auxPalabra.toString();
    }


    //Transformar String a lista de caracteres ------------------------------------------------------
    public ArrayList<Character> stringACharList(String palabra) {
        ArrayList<Character> lista = new ArrayList<>();
        for (char c : palabra.toCharArray()) {
            lista.add(c);
        }

        return lista;
    }


    //Métodos para mostrar --------------------------------------------------------------------------
    public void femeninoAnimado(String palabra) {
        //FEMENINO SINGULAR:
        nomSing.setText(nomSing(palabra));
        genSing.setText(genSingF(palabra));
        datSing.setText(datSingF(palabra));
        acuSing.setText(acuSingF(palabra));
        instSing.setText(instSingF(palabra));
        prepSing.setText(prepSingF(palabra));

        //FEMENINO PLURAL:
        nomPl.setText(nomPl(palabra));
        genPl.setText(genAcuPlFA(palabra));
        datPl.setText(datPl(palabra));
        acuPl.setText(genAcuPlFA(palabra));
        instPl.setText(instPl(palabra));
        prepPl.setText(prepPl(palabra));
    }


    public void masculinoAnimado(String palabra) {
        //MASCULINO SINGULAR:
        nomSing.setText(nomSing(palabra));
        genSing.setText(genAcuSingMA(palabra));
        datSing.setText(datSingM(palabra));
        acuSing.setText(genAcuSingMA(palabra));
        instSing.setText(instSingM(palabra));
        prepSing.setText(prepSingM(palabra));

        //MASCULINO PLURAL:
        nomPl.setText(nomPl(palabra));
        genPl.setText(genAcuPlMA(palabra));
        datPl.setText(datPl(palabra));
        acuPl.setText(genAcuPlMA(palabra));
        instPl.setText(instPl(palabra));
        prepPl.setText(prepPl(palabra));
    }


    public void masculinoInanimado(String palabra) {
        //MASCULINO SINGULAR:
        nomSing.setText(nomSing(palabra));
        genSing.setText(genAcuSingMA(palabra)); //genSingMI ES IGUAL, USAMOS UN SOLO MÉTODO
        datSing.setText(datSingM(palabra));
        acuSing.setText(nomSing(palabra));
        instSing.setText(instSingM(palabra));
        prepSing.setText(prepSingM(palabra));

        //MASCULINO PLURAL:
        nomPl.setText(nomPl(palabra));
        genPl.setText(genAcuPlMA(palabra)); //genPlMI ES IGUAL, USAMOS UN SOLO MÉTODO
        datPl.setText(datPl(palabra));
        acuPl.setText(nomPl(palabra));
        instPl.setText(instPl(palabra));
        prepPl.setText(prepPl(palabra));
    }


    public void femeninoInanimado(String palabra) {
        //FEMENINO SINGULAR:
        nomSing.setText(nomSing(palabra));
        genSing.setText(genSingF(palabra));
        datSing.setText(datSingF(palabra));
        acuSing.setText(acuSingF(palabra));
        instSing.setText(instSingF(palabra));
        prepSing.setText(prepSingF(palabra));

        //FEMENINO PLURAL:
        nomPl.setText(nomPl(palabra));
        genPl.setText(genAcuPlFA(palabra)); //genPlFI ES IGUAL, USAMOS UN SOLO MÉTODO
        datPl.setText(datPl(palabra));
        acuPl.setText(nomPl(palabra));
        instPl.setText(instPl(palabra));
        prepPl.setText(prepPl(palabra));
    }


    public void neutro(String palabra) {
        //NEUTRO SINGULAR:
        nomSing.setText(nomSing(palabra));
        genSing.setText(genSingN(palabra));
        datSing.setText(datSingN(palabra));
        acuSing.setText(nomSing(palabra));
        instSing.setText(instSingN(palabra));
        prepSing.setText(prepSingN(palabra));

        //NEUTRO PLURAL:
        nomPl.setText(nomPl(palabra));
        genPl.setText(genPlN(palabra));
        datPl.setText(datPl(palabra));
        acuPl.setText(nomPl(palabra));
        instPl.setText(instPl(palabra));
        prepPl.setText(prepPl(palabra));
    }


    //Método para revisar si la palabra se escribe siempre en plural ------------------------------------------------
    public static boolean siemprePlural(String palabra) {
        String[] excepcionesPl = {"деньги", "брюки", "ножницы", "духи", "каникулы", "шахматы", "очки"}; //agregar excepciones
        boolean soloPlural = false;

        for (String e : excepcionesPl) {
            if (palabra.equals(e)) {
                soloPlural = true;
                break;
            }
        }

        return soloPlural;
    }


    //Método para revisar si la palabra se escribe siempre en singular ----------------------------------------------
    public static boolean siempreSingular(String palabra) {
        String[] excepcionesSing = {"молоко", "теннис", "баскетбол", "футбол"}; //agregar excepciones
        boolean soloSingular = false;

        for (String e : excepcionesSing) {
            if (palabra.equals(e)) {
                soloSingular = true;
                break;
            }
        }

        return soloSingular;
    }


    //Métodos para cada caso -------------------------------------------------------------------------

    //Comunes ----------------------------------------------------
    public String nomSing(String palabra) {
        boolean siemprePlural = siemprePlural(palabra);

        if(siemprePlural) {
            palabra = "-";
        }

        return palabra;
    }


    public String nomPl(String palabra) {
        ArrayList<Character> charList = stringACharList(palabra);
        int arrayIndex = charList.size()-1;
        char[] auxList = {'г', 'к', 'х', 'ж', 'ч', 'ш', 'щ'};
        boolean existeChar = false;
        boolean esFemenina = false;
        String[] excepcionesConsonante = {"доктор", "адрес", "вечер", "гла", "город", "паспорт", "поезд", "учитель"};
        String[][] excepcionesVarias = {{"дерево", "брат", "друг", "сын", "крыло", "лист", "стул"}, {"деревья", "братья", "друзья", "сыновья", "крылья", "листья", "стулья"}};
        String[][] excepcionesIrregulares = {{"мать", "дочь", "ребёнок", "цветок", "яблоко"}, {"матери", "дочери", "дети", "цветы", "яблоки"}} ;
        String[] excepcionesNin = {"англичанин", "гражданин", "крестьянин", "мусульманин", "христианин"};
        String[] excepcionesIguales = {"метро", "пианино", "кофе", "хобби", "пальто", "радио", "шоссе", "меню"};
        boolean excepcionConsonante = false;
        boolean excepcionVaria = false;
        boolean excepcionIrregular = false;
        boolean excepcionNin = false;
        boolean excepcionIgual = false;
        boolean siempreSingular = siempreSingular(palabra);
        boolean siemprePlural = siemprePlural(palabra);
        String palabraAux = palabra;


        //Excepciones de palabras ----------------------------------
        for (String e : excepcionesConsonante) {
            if (palabra.equals(e)) {
                if (charList.get(arrayIndex).equals('ь')) {
                    charList.set(arrayIndex, 'я');
                }

                else {
                    charList.add('а');
                }

                palabraAux = charListAString(charList);
                excepcionConsonante = true;
                break;
            }
        }

        for (int j=0; j < excepcionesVarias[0].length; j++) {
            if(palabra.equals(excepcionesVarias[0][j])) {
                palabraAux = excepcionesVarias[1][j];
                excepcionVaria = true;
                break;
            }
        }

        for (int j=0; j < excepcionesIrregulares[0].length; j++) {
            if(palabra.equals(excepcionesIrregulares[0][j])) {
                palabraAux = excepcionesIrregulares[1][j];
                excepcionIrregular = true;
                break;
            }
        }

        for (String e : excepcionesNin) {
            if (palabra.equals(e)) {
                charList.set(arrayIndex - 1, 'е');
                charList.remove(arrayIndex);

                palabraAux = charListAString(charList);
                excepcionNin = true;
                break;
            }
        }

        for (String e : excepcionesIguales) {
            if (palabra.equals(e)) {
                //En el caso que sea una excepción igual, tiene que quedar igual en nomSing y en nomPl
                excepcionIgual = true;
                break;
            }
        }

        //Si termina en consonante rara
        for (char aux : auxList) {
            if (charList.get(arrayIndex).equals(aux)) {
                existeChar = true;
                break;
            }

            else if (charList.get(arrayIndex - 1).equals(aux) && charList.get(arrayIndex).equals('а')) {
                esFemenina = true;
                break;
            }
        }


        if(!excepcionConsonante && !excepcionVaria && !excepcionIrregular && !excepcionNin && !excepcionIgual && !siempreSingular && !siemprePlural) { //si no es una excepción se analiza la terminación

            char[] vocales = {'а', 'у', 'е', 'и', 'ы', 'о', 'я', 'ю', 'э'};

            //Excepciones de letras --------------------------------
            if(existeChar) {
                charList.add('и');
            }

            else if(esFemenina) {
                charList.set(arrayIndex, 'и');
            }

            else if (charList.get(arrayIndex-1).equals('е') && charList.get(arrayIndex).equals('ц')) { //caso de nacionalidades
                for (char v : vocales) {
                    if (charList.get(arrayIndex - 2).equals(v)) {
                        charList.add(arrayIndex - 1, 'й');
                        break;
                    }
                }

                charList.set(arrayIndex-1, 'ц');
                charList.set(arrayIndex, 'ы');
            }

            //Regulares ---------------
            else if (charList.get(arrayIndex).equals('а')) {
                charList.set(arrayIndex, 'ы');
            }

            else if (charList.get(arrayIndex).equals('о')) {
                charList.set(arrayIndex, 'а');
            }

            else if (charList.get(arrayIndex).equals('е')) {
                charList.set(arrayIndex, 'я');
            }

            else if (charList.get(arrayIndex-1).equals('м') && charList.get(arrayIndex).equals('я')) {
                charList.set(arrayIndex, 'е');
                charList.add('н');
                charList.add('а');
            }

            else if (charList.get(arrayIndex).equals('й') || charList.get(arrayIndex).equals('ь') || charList.get(arrayIndex).equals('я')) {
                charList.set(arrayIndex, 'и');
            }

            else{
                charList.add('ы');
            }

            palabra = charListAString(charList);
        }

        else if(siempreSingular) {
            palabra = "-";
        }

        else {
            palabra = palabraAux;
        }

        return palabra;
    }


    public String datPl(String palabra) {
        ArrayList<Character> charList = stringACharList(palabra);
        int arrayIndex = charList.size()-1;
        String[][] excepcionesIrregulares = {{"брат", "друг", "сын", "дочь", "мать", "ребёнок", "человек"}, {"братьям", "друзьям", "сыновьям", "дочерям", "матерям", "детям", "людям"}};
        boolean excepcionIrregular = false;
        boolean siempreSingular = siempreSingular(palabra);
        boolean siemprePlural = siemprePlural(palabra);
        String palabraAux = palabra;


        //Quitamos el plural a las palabras que no tienen singular, antes de declinarlas
        if(siemprePlural) {
            if(charList.get(arrayIndex).equals('и') || charList.get(arrayIndex).equals('ы')) {
                charList.remove(arrayIndex);
            }
        }

        arrayIndex = charList.size()-1;


        //Excepciones --------------
        for (int j=0; j < excepcionesIrregulares[0].length; j++) {
            if(palabra.equals(excepcionesIrregulares[0][j])) {
                palabraAux = excepcionesIrregulares[1][j];
                excepcionIrregular = true;
                break;
            }
        }

        //Regulares ----------------
        if(!excepcionIrregular && !siempreSingular) { //si no es una excepción se analiza la terminación

            if(charList.get(arrayIndex).equals('я') || charList.get(arrayIndex).equals('а')) {
                charList.add('м');
            }

            else if(charList.get(arrayIndex).equals('е') || charList.get(arrayIndex).equals('ь') || charList.get(arrayIndex).equals('й')) {
                charList.set(arrayIndex, 'я');
                charList.add('м');
            }

            else if(charList.get(arrayIndex).equals('о')) {
                charList.set(arrayIndex, 'а');
                charList.add('м');
            }

            else {
                charList.add('a');
                charList.add('м');
            }

            palabra = charListAString(charList);
        }

        else if(siempreSingular) {
            palabra = "-";
        }

        else {
            palabra = palabraAux;
        }

        return palabra;
    }


    public String instPl(String palabra) {
        ArrayList<Character> charList = stringACharList(palabra);
        int arrayIndex = charList.size()-1;
        String[][] excepcionesIrregulares = {{"брат", "друг", "сын", "дочь", "мать", "ребёнок", "человек"}, {"братьями", "друзьями", "сыновьями", "дочерьми", "матерями", "детьми", "людьми"}};
        boolean excepcionIrregular = false;
        boolean siempreSingular = siempreSingular(palabra);
        boolean siemprePlural = siemprePlural(palabra);
        String palabraAux = palabra;


        //Quitamos el plural a las palabras que no tienen singular, antes de declinarlas
        if(siemprePlural) {
            if(charList.get(arrayIndex).equals('и') || charList.get(arrayIndex).equals('ы')) {
                charList.remove(arrayIndex);
            }
        }

        arrayIndex = charList.size()-1;


        //Excepciones -----------------
        for (int j=0; j < excepcionesIrregulares[0].length; j++) {
            if(palabra.equals(excepcionesIrregulares[0][j])) {
                palabraAux = excepcionesIrregulares[1][j];
                excepcionIrregular = true;
                break;
            }
        }

        //Regulares -------------------
        if(!excepcionIrregular && !siempreSingular) { //si no es una excepción se analiza la terminación

            if (charList.get(arrayIndex).equals('я') || charList.get(arrayIndex).equals('а')) {
                charList.add('м');
                charList.add('и');
            }

            else if (charList.get(arrayIndex).equals('е') || charList.get(arrayIndex).equals('ь') || charList.get(arrayIndex).equals('й')) {
                charList.set(arrayIndex, 'я');
                charList.add('м');
                charList.add('и');
            }

            else if (charList.get(arrayIndex).equals('о')) {
                charList.set(arrayIndex, 'а');
                charList.add('м');
                charList.add('и');
            }

            else {
                charList.add('a');
                charList.add('м');
                charList.add('и');
            }

            palabra = charListAString(charList);
        }

        else if(siempreSingular) {
            palabra = "-";
        }

        else {
            palabra = palabraAux;
        }

        return palabra;
    }


    public String prepPl(String palabra) {
        ArrayList<Character> charList = stringACharList(palabra);
        int arrayIndex = charList.size()-1;
        String[][] excepcionesIrregulares = {{"брат", "друг", "сын", "дочь", "мать", "ребёнок", "человек"}, {"братьях", "друзьях", "сыновьях", "дочерях", "матерях", "детях", "людях"}};
        boolean excepcionIrregular = false;
        boolean siempreSingular = siempreSingular(palabra);
        boolean siemprePlural = siemprePlural(palabra);
        String palabraAux = palabra;


        //Quitamos el plural a las palabras que no tienen singular, antes de declinarlas
        if(siemprePlural) {
            if(charList.get(arrayIndex).equals('и') || charList.get(arrayIndex).equals('ы')) {
                charList.remove(arrayIndex);
            }
        }

        arrayIndex = charList.size()-1;


        //Excepciones -----------------
        for (int j=0; j < excepcionesIrregulares[0].length; j++) {
            if(palabra.equals(excepcionesIrregulares[0][j])) {
                palabraAux = excepcionesIrregulares[1][j];
                excepcionIrregular = true;
                break;
            }
        }

        //Regulares -------------------
        if(!excepcionIrregular && !siempreSingular) { //si no es una excepción se analiza la terminación

            if (charList.get(arrayIndex).equals('я') || charList.get(arrayIndex).equals('а')) {
                charList.add('х');
            }

            else if (charList.get(arrayIndex).equals('е') || charList.get(arrayIndex).equals('ь') || charList.get(arrayIndex).equals('й')) {
                charList.set(arrayIndex, 'я');
                charList.add('х');
            }

            else if (charList.get(arrayIndex).equals('о')) {
                charList.set(arrayIndex, 'а');
                charList.add('х');
            }

            else {
                charList.add('а');
                charList.add('х');
            }

            palabra = charListAString(charList);
        }

        else if(siempreSingular) {
            palabra = "-";
        }

        else {
            palabra = palabraAux;
        }

        return palabra;
    }


    //FEMENINOS singulares -----------------------------------------

    public String genSingF(String palabra) {
        ArrayList<Character> charList = stringACharList(palabra);
        int arrayIndex = charList.size()-1;
        char[] auxList = {'г', 'к', 'х', 'ж', 'ч', 'ш', 'щ'};
        boolean existeChar = false;
        String[][] excepcionesIrregulares = {{"дочь", "мать"}, {"дочери", "матери"}};
        boolean excepcionIrregular = false;
        boolean siemprePlural = siemprePlural(palabra);
        String palabraAux = palabra;


        //Excepciones -----------------
        for (int j=0; j < excepcionesIrregulares[0].length; j++) {
            if(palabra.equals(excepcionesIrregulares[0][j])) {
                palabraAux = excepcionesIrregulares[1][j];
                excepcionIrregular = true;
                break;
            }
        }


        if(!excepcionIrregular && !siemprePlural) { //si no es una excepción se analiza la terminación

            //Si termina en 'а' y la anterior es una consonante rara
            if (charList.get(arrayIndex).equals('а')) {
                for (char aux : auxList) {
                    if (charList.get(arrayIndex - 1).equals(aux)) {
                        existeChar = true;
                        break;
                    }
                }
            }

            if (existeChar) {
                charList.set(arrayIndex, 'и');
            }

            //Regulares ----------------------------
            else if (charList.get(arrayIndex).equals('а')) {
                charList.set(arrayIndex, 'ы');
            }

            else if (charList.get(arrayIndex).equals('я') || charList.get(arrayIndex).equals('ь')) {
                charList.set(arrayIndex, 'и');
            }

            palabra = charListAString(charList);
        }

        else if(siemprePlural) {
            palabra = "-";
        }

        else {
            palabra = palabraAux;
        }

        return palabra;
    }


    public String datSingF(String palabra) {
        ArrayList<Character> charList = stringACharList(palabra);
        int arrayIndex = charList.size()-1;
        String[][] excepcionesIrregulares = {{"дочь", "мать"}, {"дочери", "матери"}};
        boolean excepcionIrregular = false;
        boolean siemprePlural = siemprePlural(palabra);
        String palabraAux = palabra;


        //Excepciones -----------------
        for (int j=0; j < excepcionesIrregulares[0].length; j++) {
            if(palabra.equals(excepcionesIrregulares[0][j])) {
                palabraAux = excepcionesIrregulares[1][j];
                excepcionIrregular = true;
                break;
            }
        }

        //Regulares --------------------
        if(!excepcionIrregular && !siemprePlural) { //si no es una excepción se analiza la terminación

            if (charList.get(arrayIndex - 1).equals('и') && charList.get(arrayIndex).equals('я')) {
                charList.set(arrayIndex, 'и');
            }

            else if (charList.get(arrayIndex).equals('а') || charList.get(arrayIndex).equals('я')) {
                charList.set(arrayIndex, 'е');
            }

            else if (charList.get(arrayIndex).equals('ь')) {
                charList.set(arrayIndex, 'и');
            }

            palabra = charListAString(charList);
        }

        else if(siemprePlural) {
            palabra = "-";
        }

        else {
            palabra = palabraAux;
        }

        return palabra;
    }


    public String acuSingF(String palabra) {
        ArrayList<Character> charList = stringACharList(palabra);
        int arrayIndex = charList.size()-1;
        boolean siemprePlural = siemprePlural(palabra);


        //Regulares ------------------
        if(!siemprePlural) { //si no es una excepción se analiza la terminación

            if(charList.get(arrayIndex).equals('я')) {
                charList.set(arrayIndex, 'ю');
            }

            else if(charList.get(arrayIndex).equals('а')){
                charList.set(arrayIndex,'у');
            }

            palabra = charListAString(charList);
        }

        else if(siemprePlural) {
            palabra = "-";
        }

        return palabra;
    }


    public String instSingF(String palabra) {
        ArrayList<Character> charList = stringACharList(palabra);
        int arrayIndex = charList.size()-1;
        String[][] excepcionesIrregulares = {{"дочь", "мать"}, {"дочерью", "матерью"}};
        boolean excepcionIrregular = false;
        boolean siemprePlural = siemprePlural(palabra);
        String palabraAux = palabra;


        //Excepciones -----------------
        for (int j=0; j < excepcionesIrregulares[0].length; j++) {
            if(palabra.equals(excepcionesIrregulares[0][j])) {
                palabraAux = excepcionesIrregulares[1][j];
                excepcionIrregular = true;
                break;
            }
        }

        //Regulares --------------------------
        if(!excepcionIrregular && !siemprePlural) { //si no es una excepción se analiza la terminación

            if (charList.get(arrayIndex).equals('а')) {
                charList.set(arrayIndex, 'о');
                charList.add('й');
            }

            else if (charList.get(arrayIndex).equals('я')) {
                charList.set(arrayIndex, 'е');
                charList.add('й');
            }

            else if (charList.get(arrayIndex).equals('ь')) {
                charList.add('ю');
            }

            palabra = charListAString(charList);
        }

        else if(siemprePlural) {
            palabra = "-";
        }

        else {
            palabra = palabraAux;
        }

        return palabra;
    }


    public String prepSingF(String palabra) {
        ArrayList<Character> charList = stringACharList(palabra);
        int arrayIndex = charList.size()-1;
        String[][] excepcionesIrregulares = {{"дочь", "мать"}, {"дочери", "матери"}};
        boolean excepcionIrregular = false;
        boolean siemprePlural = siemprePlural(palabra);
        String palabraAux = palabra;


        //Excepciones -----------------
        for (int j=0; j < excepcionesIrregulares[0].length; j++) {
            if(palabra.equals(excepcionesIrregulares[0][j])) {
                palabraAux = excepcionesIrregulares[1][j];
                excepcionIrregular = true;
                break;
            }
        }

        //Regulares --------------------------
        if(!excepcionIrregular && !siemprePlural) { //si no es una excepción se analiza la terminación

            if (charList.get(arrayIndex - 1).equals('и') && charList.get(arrayIndex).equals('я')) {
                charList.set(arrayIndex, 'и');
            }

            else if (charList.get(arrayIndex).equals('а') || charList.get(arrayIndex).equals('я')) {
                charList.set(arrayIndex, 'е');
            }

            else if (charList.get(arrayIndex).equals('ь')) {
                charList.set(arrayIndex, 'и');
            }

            palabra = charListAString(charList);
        }

        else if(siemprePlural) {
            palabra = "-";
        }

        else {
            palabra = palabraAux;
        }

        return palabra;
    }


    //FEMENINOS plurales -----------------------------------------

    public String genAcuPlFA(String palabra) {
        ArrayList<Character> charList = stringACharList(palabra);
        int arrayIndex = charList.size()-1;
        char[] auxList = {'б', 'л', 'д', 'м', 'ц', 'к', 'н', 'г', 'ш', 'щ', 'з', 'х', 'ф', 'в', 'п', 'р', 'ж', 'ч', 'с', 'т', 'ь', 'ъ'};
        char[] auxList2 = {'б', 'л', 'д', 'м'};
        String[][] excepcionesIrregulares = {{"дочь", "мать"}, {"дочери", "матери"}};
        boolean excepcionIrregular = false;
        boolean siempreSingular = siempreSingular(palabra);
        boolean siemprePlural = siemprePlural(palabra);
        String palabraAux = palabra;


        //Quitamos el plural a las palabras que no tienen singular, antes de declinarlas
        if(siemprePlural) {
            if(charList.get(arrayIndex).equals('и') || charList.get(arrayIndex).equals('ы')) {
                charList.remove(arrayIndex);
            }
        }

        arrayIndex = charList.size()-1;


        //Excepciones -----------------
        for (int j=0; j < excepcionesIrregulares[0].length; j++) {
            if(palabra.equals(excepcionesIrregulares[0][j])) {
                palabraAux = excepcionesIrregulares[1][j];
                excepcionIrregular = true;
                break;
            }
        }


        //Regulares --------------------------
        if(!excepcionIrregular && !siempreSingular) { //si no es una excepción se analiza la terminación

            if(charList.get(arrayIndex-1).equals('и') && charList.get(arrayIndex).equals('я')) {
                charList.set(arrayIndex, 'й');
            }

            else if(charList.get(arrayIndex).equals('я')) {
                charList.set(arrayIndex, 'ь');
            }

            else if(charList.get(arrayIndex).equals('ь')) {
                charList.set(arrayIndex, 'е');
                charList.add('й');
            }

            else if(charList.get(arrayIndex).equals('а'))  { //Si no termina en ninguno de los anteriores, termina en 'а'
                charList.remove(arrayIndex);

                for(char auxO : auxList2) {
                    if(charList.get(arrayIndex - 1).equals('к') && charList.get(arrayIndex - 2).equals(auxO)) {
                        charList.add(arrayIndex-1, 'о');
                        break;
                    }

                    else {
                        for (char auxE : auxList) {
                            if (charList.get(arrayIndex - 1).equals(auxE)) {
                                for (char auxE2 : auxList) {
                                    if (charList.get(arrayIndex - 2).equals(auxE2)) {
                                        charList.add(arrayIndex-1, 'е');
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        break;
                    }
                }

                    /*
                    if (charList.get(arrayIndex - 1).equals(aux)) {
                        for (char aux2 : auxList) {
                            if (charList.get(arrayIndex - 2).equals(aux2)) {
                                existeChar = true;
                                letraAux = charList.get(arrayIndex - 1);
                                break;
                            }
                        }
                        break;
                    }


                //Excepciones ---------------------
                if(existeChar) {
                    charList.add(arrayIndex-1, 'е');
                    charList.add('/');
                    charList.add('о');
                    charList.add(letraAux);
                }*/
            }

            palabra = charListAString(charList);
        }

        else if(siempreSingular) {
            palabra = "-";
        }

        else {
            palabra = palabraAux;
        }

        return palabra;
    }


    //MASCULINOS singulares -----------------------------------------

    public String genAcuSingMA(String palabra) {
        ArrayList<Character> charList = stringACharList(palabra);
        int arrayIndex = charList.size()-1;
        boolean siemprePlural = siemprePlural(palabra);


        //Regulares --------------------------
        if(!siemprePlural) { //si no es una excepción se analiza la terminación

            if(charList.get(arrayIndex).equals('й') || charList.get(arrayIndex).equals('ь')) {
                charList.set(arrayIndex, 'я');
            }

            else {
                charList.add('a');
            }

            palabra = charListAString(charList);
        }

        else if(siemprePlural) {
            palabra = "-";
        }

        return palabra;
    }


    public String datSingM(String palabra) {
        ArrayList<Character> charList = stringACharList(palabra);
        int arrayIndex = charList.size()-1;
        boolean siemprePlural = siemprePlural(palabra);


        //Regulares --------------------------
        if(!siemprePlural) { //si no es una excepción se analiza la terminación

            if(charList.get(arrayIndex).equals('й') || charList.get(arrayIndex).equals('ь')) {
                charList.set(arrayIndex, 'ю');
            }

            else {
                charList.add('у');
            }

            palabra = charListAString(charList);
        }

        else if(siemprePlural) {
            palabra = "-";
        }

        return palabra;
    }


    public String instSingM(String palabra) {
        ArrayList<Character> charList = stringACharList(palabra);
        int arrayIndex = charList.size()-1;
        char[] auxList = {'ж', 'ч', 'ш', 'щ', 'ц'};
        boolean existeChar = false;
        boolean siemprePlural = siemprePlural(palabra);


        //Excepciones --------------------------
        for (char aux : auxList) {
            if (charList.get(arrayIndex).equals(aux)) {
                existeChar = true;
                break;
            }
        }

        if(!siemprePlural) { //si no es una excepción se analiza la terminación

            if(existeChar){
                charList.add('е');
                charList.add('м');
            }

            //Regulares --------------------------
            else if(charList.get(arrayIndex).equals('й') || charList.get(arrayIndex).equals('ь')) {
                charList.set(arrayIndex, 'е');
                charList.add('м');
            }

            else {
                charList.add('о');
                charList.add('м');
            }

            palabra = charListAString(charList);
        }

        else if(siemprePlural) {
            palabra = "-";
        }

        return palabra;
    }


    public String prepSingM(String palabra) {
        ArrayList<Character> charList = stringACharList(palabra);
        int arrayIndex = charList.size()-1;
        boolean siemprePlural = siemprePlural(palabra);


        //Regulares --------------------------
        if(!siemprePlural) { //si no es una excepción se analiza la terminación

            if(charList.get(arrayIndex).equals('й') || charList.get(arrayIndex).equals('ь')) {
                charList.set(arrayIndex, 'е');
            }

            else {
                charList.add('е');
            }

            charList.add('/');
            charList.add('у');

            palabra = charListAString(charList);
        }

        else if(siemprePlural) {
            palabra = "-";
        }

        return palabra;
    }


    //MASCULINOS plurales -----------------------------------------

    public String genAcuPlMA(String palabra) {
        ArrayList<Character> charList = stringACharList(palabra);
        int arrayIndex = charList.size()-1;
        char[] auxList = {'ж', 'ч', 'ш', 'щ'};
        boolean existeChar = false;
        String[][] excepcionesIrregulares = {{"брат", "друг", "сын", "дочь", "мать", "ребёнок", "человек", "англичанин"}, {"братьев", "друзей", "сыновей", "дочерей", "матерей", "детей", "людей", "англичан"}};
        boolean excepcionIrregular = false;
        boolean siempreSingular = siempreSingular(palabra);
        boolean siemprePlural = siemprePlural(palabra);
        String palabraAux = palabra;


        //Quitamos el plural a las palabras que no tienen singular, antes de declinarlas
        if(siemprePlural) {
            if(charList.get(arrayIndex).equals('и') || charList.get(arrayIndex).equals('ы')) {
                charList.remove(arrayIndex);
            }
        }

        arrayIndex = charList.size()-1;


        //Excepciones ------------------------
        for (int j=0; j < excepcionesIrregulares[0].length; j++) {
            if(palabra.equals(excepcionesIrregulares[0][j])) {
                palabraAux = excepcionesIrregulares[1][j];
                excepcionIrregular = true;
                break;
            }
        }

        for (char aux : auxList) {
            if (charList.get(arrayIndex).equals(aux)) {
                existeChar = true;
                break;
            }
        }


        if(!excepcionIrregular && !siempreSingular) { //si no es una excepción se analiza la terminación

            if (existeChar) {
                charList.add('е');
                charList.add('й');
            }

            //Regulares --------------------------
            else if (charList.get(arrayIndex).equals('й')) {
                charList.set(arrayIndex, 'е');
                charList.add('в');
            }

            else if (charList.get(arrayIndex).equals('ь')) {
                charList.set(arrayIndex, 'е');
                charList.add('й');
            }

            else {
                charList.add('о');
                charList.add('в');
            }

            palabra = charListAString(charList);
        }

        else if(siempreSingular) {
            palabra = "-";
        }

        else {
            palabra = palabraAux;
        }

        return palabra;
    }


    //NEUTROS singulares -----------------------------------------

    public String genSingN(String palabra) {
        ArrayList<Character> charList = stringACharList(palabra);
        int arrayIndex = charList.size()-1;
        boolean siemprePlural = siemprePlural(palabra);


        //Regulares --------------------------
        if(!siemprePlural) { //si no es una excepción se analiza la terminación

            if(charList.get(arrayIndex).equals('о')) {
                charList.set(arrayIndex, 'а');
            }

            else if(charList.get(arrayIndex).equals('е')) {
                charList.set(arrayIndex, 'я');
            }

            else if(charList.get(arrayIndex-1).equals('м') && charList.get(arrayIndex).equals('я')) {
                charList.set(arrayIndex, 'е');
                charList.add('н');
                charList.add('и');
            }

            palabra = charListAString(charList);
        }

        else if(siemprePlural) {
            palabra = "-";
        }

        return palabra;
    }


    public String datSingN(String palabra) {
        ArrayList<Character> charList = stringACharList(palabra);
        int arrayIndex = charList.size()-1;
        boolean siemprePlural = siemprePlural(palabra);


        //Regulares --------------------------
        if(!siemprePlural) { //si no es una excepción se analiza la terminación

            if(charList.get(arrayIndex).equals('о')) {
                charList.set(arrayIndex, 'у');
            }

            else if(charList.get(arrayIndex).equals('е')) {
                charList.set(arrayIndex, 'ю');
            }

            else if(charList.get(arrayIndex-1).equals('м') && charList.get(arrayIndex).equals('я')) {
                charList.set(arrayIndex, 'е');
                charList.add('н');
                charList.add('и');
            }

            palabra = charListAString(charList);
        }

        else if(siemprePlural) {
            palabra = "-";
        }

        return palabra;
    }


    public String instSingN(String palabra) {
        ArrayList<Character> charList = stringACharList(palabra);
        int arrayIndex = charList.size()-1;
        boolean siemprePlural = siemprePlural(palabra);


        //Regulares --------------------------
        if(!siemprePlural) { //si no es una excepción se analiza la terminación

            if(charList.get(arrayIndex).equals('о') || charList.get(arrayIndex).equals('е')) {
                charList.add('м');
            }

            else if(charList.get(arrayIndex-1).equals('м') && charList.get(arrayIndex).equals('я')) {
                charList.set(arrayIndex, 'е');
                charList.add('н');
                charList.add('е');
                charList.add('м');
            }

            palabra = charListAString(charList);
        }

        else if(siemprePlural) {
            palabra = "-";
        }

        return palabra;
    }


    public String prepSingN(String palabra) {
        ArrayList<Character> charList = stringACharList(palabra);
        int arrayIndex = charList.size()-1;
        boolean siemprePlural = siemprePlural(palabra);


        //Regulares --------------------------
        if(!siemprePlural) { //si no es una excepción se analiza la terminación

            if(charList.get(arrayIndex).equals('о')) {
                charList.set(arrayIndex, 'е');
            }

            else if(charList.get(arrayIndex-1).equals('и') && charList.get(arrayIndex).equals('е')) {
                charList.set(arrayIndex, 'и');
            }

            else if(charList.get(arrayIndex-1).equals('м') && charList.get(arrayIndex).equals('я')) {
                charList.set(arrayIndex, 'е');
                charList.add('н');
                charList.add('и');
            }

            palabra = charListAString(charList);
        }

        else if(siemprePlural) {
            palabra = "-";
        }

        return palabra;
    }


    //NEUTROS plurales -----------------------------------------

    public String genPlN(String palabra) {
        ArrayList<Character> charList = stringACharList(palabra);
        int arrayIndex = charList.size()-1;
        boolean siempreSingular = siempreSingular(palabra);
        boolean siemprePlural = siemprePlural(palabra);


        //Quitamos el plural a las palabras que no tienen singular, antes de declinarlas
        if(siemprePlural) {
            if(charList.get(arrayIndex).equals('и') || charList.get(arrayIndex).equals('ы')) {
                charList.remove(arrayIndex);
            }
        }

        arrayIndex = charList.size()-1;


        //Excepciones ------------------------ REVISAR LOS PARES DE CONSONANTES QUE PRODUCEN EXCEPCIÓN - ADRIANA -----------


        //Regulares --------------------------
        if(!siempreSingular) {

            if(charList.get(arrayIndex).equals('о')) {
                charList.remove(arrayIndex);
            }

            else if(charList.get(arrayIndex-1).equals('и') && charList.get(arrayIndex).equals('е')) {
                charList.set(arrayIndex, 'й');
            }

            else if(charList.get(arrayIndex).equals('е')) {
                charList.add('й');
            }

            palabra = charListAString(charList);
        }

        else if(siempreSingular) {
            palabra = "-";
        }

        return palabra;
    }




    //Métodos que vienen por default -----------------------------------------------------------------------------------------------
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}