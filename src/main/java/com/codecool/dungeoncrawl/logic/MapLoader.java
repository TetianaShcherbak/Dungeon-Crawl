//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.actors.Skeleton;
import com.codecool.dungeoncrawl.logic.items.*;

import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {
    public MapLoader() {
    }

    public static GameMap loadMap() {
        InputStream is = MapLoader.class.getResourceAsStream("/map2.txt");
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();// /2
        int height = scanner.nextInt();// /2
        scanner.nextLine();
        GameMap map = new GameMap(width, height, CellType.EMPTY);

        for(int y = 0; y < height; ++y) {
            String line = scanner.nextLine();

            for(int x = 0; x < width; ++x) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch(line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '!':
                        case '"':
                        case '$':
                        case '%':
                        case '&':
                        case '\'':
                        case '(':
                        case ')':
                        case '*':
                        case '+':
                        case ',':
                        case '-':
                        case '/':
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                        case ':':
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                        case '?':
                        case 'E':
                        case 'F':
                        case 'G':
                        case 'H':
                        case 'I':
                        case 'J':
                        case 'K':
                        case 'L':
                        case 'M':
                        case 'N':
                        case 'R':
                        case 'T':
                        case 'U':
                        case 'V':
                        case 'W':
                        case 'X':
                        case 'Y':
                        case 'Z':
                        case '[':
                        case '\\':
                        case ']':
                        case '^':
                        case '_':
                        case '`':
                        case 'a':
                        case 'c':
                        case 'e':
                        case 'g':
                        case 'i':
                        case 'j':
                        case 'l':
                        case 'm':
                        case 'n':
                        case 'o':
                        case 'p':
                        case 'u':
                        case 'v':
                        case 'w':
                        case 'x':
                        case 'y':
                        default:
                            char var10002 = line.charAt(x);
                            throw new RuntimeException("Unrecognized character: '" + var10002 + "'");
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell));
                            break;
                        case 'A':
                            cell.setType(CellType.FLOOR);
                            new Arrow(cell, 10);
                            break;
                        case 'B':
                            cell.setType(CellType.BRIDGE);
                            break;
                        case 'C':
                            cell.setType(CellType.FLOOR);
                            new Cheese(cell, 5);
                            break;
                        case 'D':
                            cell.setType(CellType.DOORCLOSE);
                            break;
                        case 'O':
                            cell.setType(CellType.OAKS);
                            break;
                        case 'P':
                            cell.setType(CellType.PINES);
                            break;
                        case 'Q':
                            cell.setType(CellType.BRIDGESTART);
                            break;
                        case 'S':
                            cell.setType(CellType.FLOOR);
                            new Sword(cell, 10);
                            break;
                        case 'b':
                            cell.setType(CellType.FLOOR);
                            new Bow(cell, 8);
                            break;
                        case 'd':
                            cell.setType(CellType.DOOROPEN);
                            break;
                        case 'f':
                            cell.setType(CellType.FIRE);
                            break;
                        case 'h':
                            cell.setType(CellType.FLOOR);
                            new Hammer(cell, 5);
                            break;
                        case 'k':
                            cell.setType(CellType.FLOOR);
                            new Key(cell, 0);
                            break;
                        case 'q':
                            cell.setType(CellType.FLOOR);
                            new Helmet(cell, 5);
                            break;
                        case 'r':
                            cell.setType(CellType.RIVERBODY);
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            new Skeleton(cell);
                            break;
                        case 't':
                            cell.setType(CellType.STAIRS);
                            break;
                        case 'z':
                            cell.setType(CellType.FLOOR);
                            new Skull(cell, 8);
                    }
                }
            }
        }

        return map;
    }
}
