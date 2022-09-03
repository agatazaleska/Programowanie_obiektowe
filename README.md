# Programowanie_obiektowe
Zadania zaliczeniowe z programowania obiektowego (2 semestr)

ROBY
Zasymulujmy ewolucję kodu robów

Plansza

Symulacja odbywa się w (ile_tur) turach, Świat robów to prostokątna plansza składająca się z
rozmiar_planszy_x*rozmiar_planszy_y pól. Roby znajdują się na pojedynczych polach i mogą
przechodzić między nimi. Zakładamy, że plansza ma posklejane ze sobą brzegi, tak więc po ostatniej
kolumnie/wierszu następuje pierwsza/pierwszy i analogicznie przed pierwszą kolumną/pierwszym
wierszem. Wynika stąd, że każde pole ma tyle samo sąsiadów.
Na początku symulacji w losowych (nie koniecznie różnych) miejscach planszy umieszczanych jest
pocz_ile_robów robów, każdy wyposażony w początkowy program pocz_progr i pocz_energia
jednostek energii.

Pola

Na jednym polu może być dowolnie wiele (w tym zero) robów. Każde pole planszy jest jednego z dwu
rodzajów: puste lub żywieniowe. W tym drugim przypadku jest na nim na początku symulacji
pożywienie. Jeśli na takie pole wejdzie rob, to zjada to pożywienie (w całości), co daje mu energię do
życia (ile_daje_jedzenie). Pole zaczyna się regenerować, w tym czasie wchodzące roby nie mogą się
pożywić. Po ile_rośnie_jedzenie turach na polu znów pojawia się pożywienie. Zje je pierwszy rob,
który wejdzie na to pole (roby, które stoją na polu w momencie pojawienia się pożywienia nie zjadają
go, w celu zjedzenia pożywienia trzeba wejść na pole - promujemy ruch i zdrowy tryb życia :) ).
Również roby, które na początku symulacji zostaną umieszczone na polach z pożywieniem, nie mogą
go zjeść.

Roby

Każdy rob znajduje się na jednym polu planszy i jest skierowany w jednym z czterech kierunków
(góra, prawo, dól, lewo). Każdy rob ma swój program. W każdej turze wykonuje go instrukcja po
instrukcji (p. spis instrukcji) do końca (chyba że skończy mu się energia). Wykonanie każdej instrukcji
zużywa jedną jednostkę energii roba. Samo przeżycie jednej tury (nawet z pustym programem)
wymaga koszt_tury jednostek energii.
Jedynym sposobem uzupełnienia energii jest wejścia na pole z pożywieniem (tak jak napisano
wcześniej, jeśli na polu jest jedzenie, to zjedzenie go daje wtedy robowi ile_daje_jedzenie jednostek
energii). Jeśli w którymkolwiek momencie (np. w trakcie wykonywania programu) stan zapasu energii
roba spadnie poniżej zera, to rob przestaje działać/umiera i od następnej tury nie ma go już na
planszy.

Powielanie

W każdej turze rob może (z prawdopodobieństwem pr_powielenia) powielić się. Powielenie oznacza,
że w tym samym miejscu pojawia się nowy rob, który ma zmutowany program rodzica i część
(ułamek_energii_rodzica) jego energii (o tę energię maleje oczywiście zapas energii rodzica).
Powielenie jest możliwe tylko wtedy, gdy potencjalny rodzic ma co najmniej limit_powielania jednostek
energii. Nowopowstały rob jest skierowany w przeciwną stronę niż rodzic. Wykonywanie programu
roba oraz zużywanie energii zaczyna się w następnej po powstaniu kolejce.

Mutacje

Kod programu nowego roba może być inny niż kod rodzica. Z prawdopodobieństwem
pr_usunięcia_instr nowy program ma usuniętą ostatnią instrukcję (o ile oczywiście kod rodzica nie był
pusty). Z prawdopodobieństwem pr_dodania_instr nowy program ma na końcu kodu jedną, losowo
wybraną z dostępnych (spis_instr), instrukcję więcej. Z pr_zmiany_instr jedna z instrukcji programu (o
ile oczywiście w ogóle jakieś są) jest zmieniona na jedną z dostępnych (być może tę samą). Wszystkie
mutacje mogą się zdarzyć przy tworzeniu kodu programu (w podanej kolejności), może też się
zdarzyć, że żadna nie zajdzie.

Spis instrukcji

W kodzie programów mogą występować tylko instrukcje ze spis_instr. Ten spis w kolejnym
uruchomieniu symulacji może zawierać tylko część z wymienionych poniżej instrukcji (ale może
zawierać wszystkie, o ile gdzie indziej nie jest podane inaczej):
● l (lewo) obróć się o 90 stopni w lewo,
● p (prawo) obróć się o 90 stopni w prawo,
● i (idź) idź do przodu o jedno pole (jeśli tam jest pożywienie, to je zjedz),
● w (wąchaj) sprawdź, czy któraś z (czterech) sąsiednich komórek ma pożywienie, jeśli tak, to
zwróć się w jej stronę (bez przechodzenia),
● j (jedz) sprawdź, czy któraś z (ośmiu) sąsiednich komórek (także te na ukos) ma pożywienie,
jeśli tak, to przejdź tam i zjedz, wpp nic nie rób.

Co program ma robić

Program powinien najpierw utworzyć planszę na podstawie pliku plansza.txt.
Następnie powinien wykonać symulację zgodnie z zadanymi parametrami. Program powinien
wypisywać w trakcie symulacji co zadaną liczbę tur (co_ile_wypisz ) oraz przed i po zakończeniu
symulacji tekstowy opis bieżącego stanu symulacji (zawierający m.in. stany wszystkich robów).
Do tego po każdej turze powinien wypisać (w jednym wierszu, w podanej kolejności) podstawowe
dane o stanie symulacji: numer tury, liczba robów, liczba pól z żywnością, minimalna, średnia,
maksymalna długość programu robów, minimalna, średnia i maksymalna energia roba, minimalny,
średni i maksymalny wiek roba, np:
245, rob: 120, żyw: 340, prg: 3/4.56/78, energ: 1/4.34/26, wiek: 1/12.46/78




ROBSON

Celem zadania będzie stworzenie interpretera pewnego prostego języka programowania o
nazwie ROBSON.
Twój program powinien umożliwiać:
● Wczytanie programu w języku ROBSON zapisanego w formacie JSON
● Uruchomienie programu w języku ROBSON
● Konwersję programu w języku ROBSON do kompilowalnego programu w Javie
● Zapis wczytanego programu do pliku w formacie JSON.
W języku ROBSON Program w składa się z następujących elementów:
● Instrukcji Bloku wykonanie bloku instrukcji polega na wywołaniu funkcji wykonaj dla
każdej instrukcji z bloku.
● wyrażenia logiczne stałe prawda fałsz operacje Oraz Not Lub a także operacjeTyp Wartość wynikowa
124

porównujące wyrażenie arytmetyczne większe mniejsze równe
● wyrażenia arytmetyczne stała liczbowa Plus Minus Mnoz dziel
● instrukcję warunkową if składającej się z wyrazanienia logicznego oraz bloku
instrukcji wykonywanej w przypadku gdy obliczenie wyrażenia da wartość true oraz
bloku instrukcji wykonywanej w przeciwnym przypadku
● Instrukcja pętli składa się wyrażenia logicznego oraz bloku instrukcji
Wykonanie Instrukcji pętli polega cyklicznym wykonywaniu następujących operacji
obliczenia wartości wyrażenia logicznego jeśli to obliczenie da wartość True to
wykonujemy blok instrukcji, w przeciwnym wypadku kończymy wykonanie instrukcji
● W programie dostępne są zmienne globalne (początkowo zainicjalizowane na 0) i
instrukcje przypisania.
Programy z naszym języku będą zapisywane w piłkach JSON

W formacie JSON każda instrukcja będzie odpowiadać słownikowi, który będzie zawierał
obowiązkowe pole “typ” oraz dodatkowe argumenty wg następującej listy

- Blok instrukcje - lista instrukcji lub wyrażeń
- If warunek - wyrażenie opisujące warunek logiczny
- blok_prawda - wyrażenie które ma być wyliczone gdy warunek jest prawdziwy
- blok_falsz - (atrybut opcjonalny) wyrażenie które ma być wykonane gdy warunek jest fałszywy
- While warunek - wyrażenie opisujące warunek logiczny
- blok - wyrażenie które ma być wykonane w pojedynczej iteracji pętli
- Przypisanie nazwa - nazwa zmiennej do przypisania (str)
- wartosc - wyrażenie opisujące prawą stronę przypisania
- Plus|Minus|Razy|Dzielenie argument1 - wyrażenie opisujące pierwszy argument
                            argument2 - wyrażenie opisujące drugi argument
- And|Or argument1 - wyrażenie opisujące pierwszy argument
         argument2 - wyrażenie opisujące drugi argument
- < | > | <= | >= | == argument1 - wyrażenie opisujące pierwszy argument
                       argument2 - wyrażenie opisujące drugi argument
- Not argument - wyrażenie opisujące argument
- Liczba wartosc - wartość stałej liczbowej (double)
- True|False -
- Zmienna nazwa - nazwa zmiennej (str)

Każda instrukcja wylicza wartość wyniką używając następujących reguł

- Blok - Wartość ostatniej instrukcji lub 0 w przypadku pustego bloku
- If - Wartość blok_prawda jeśli warunek jest prawdziwy lub wartość blok_falsz wpp
- While - 0
- Przypisanie - Wartość zmiennej (po przypisaniu)
- Plus|Minus|Razy|Dzielenie - wartość wyniku wykonania operacji (liczbowa)
- And|Or - Wartość wyniku wykonania operacji (0 - fałsz, 1 - true)
- < | > | <= | = | == - Wartość wyniku wykonania operacji (0 - fałsz, 1 - true)
- Not - Wartość wyniku wykonania operacji (0 - fałsz, 1 - true)
- Liczba - Wartość liczby
- True|False - 0 - fałsz, 1 - true
- Zmienna - Wartość zmiennej
