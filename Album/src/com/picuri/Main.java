package com.picuri;

import java.util.*;

public class Main {
    private static List<Album> albums = new ArrayList<Album>();
    public static void main(String[] args) {

        Album album = new Album("Love Yourself 'tear'", "BTS");
        album.addSong("Intro: Singularity",3.17);
        album.addSong("Fake Love",4.02);
        album.addSong("s",4.02);
        album.addSong("134340",3.50);
        album.addSong("I",3.31);
        album.addSong("Love Maze",3.41);
        album.addSong("Magic Shop",4.35);
        album.addSong("Airplane pt.2",3.38);
        album.addSong("Anpanman",3.52);
        album.addSong("So What",4.41);
        album.addSong("Outro: Tear",4.44);
        albums.add(album);

        album = new Album("Rise", "Skillet");
        album.addSong("Rise",4.20);
        album.addSong("Sick of it",3.11);
        album.addSong("Good to Be Alive",4.59);
        album.addSong("Not Gonna Die",3.45);
        album.addSong("Circus for a Psycho",4.31);
        album.addSong("American Noise",4.09);
        album.addSong("Madness in Me",4.17);
        album.addSong("Salvation",3.45);
        album.addSong("Fire and Fury",3.56);
        album.addSong("Mz Religion",4.12);
        album.addSong("Hard to Find",3.48);
        album.addSong("What I Believe",3.19);
        albums.add(album);

        List<Song> playList = new ArrayList<Song>();
        albums.get(0).addToPlayList("Love Maze",playList);
        albums.get(1).addToPlayList("Rise",playList);
        albums.get(0).addToPlayList("Fake Love",playList);
        albums.get(0).addToPlayList("Begin",playList);
        albums.get(1).addToPlayList(5,playList);
        albums.get(1).addToPlayList(3,playList);
        albums.get(1).addToPlayList(25,playList);
        play(playList);

    }

    private static void printMenu() {
        System.out.println("Available actions:\n");
        System.out.println("0 -- Show menu options" +
                "\n1 -- Replay" +
                "\n2 -- Next song" +
                "\n3 -- Previous song" +
                "\n4 -- Show the playlist" +
                "\n5 -- Remove song from the playlist"+
                "\n6 -- Quit"+
                "\npress:");
    }

    private static void play(List<Song> playList) {
        boolean quit = false;
        boolean goingForward = true;
        final ListIterator<Song> listIterator = playList.listIterator();
        Scanner scanner = new Scanner(System.in);

        if (playList.size() == 0) {
            System.err.println("No songs in the playlist");
            return;
        } else {
            System.out.println("***********************");
            System.out.println("Now playing: " + listIterator.next());
            System.out.println("***********************");
            printMenu();
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying: " + listIterator.previous().toString());
                            goingForward = false;
                        } else {
                            System.err.println("We are at the start of the list");

                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying: " + listIterator.next().toString());
                            goingForward = true;
                        } else {
                            System.err.println("Reached the end of the list");
                        }
                    }
                    break;
                case 2:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing: " + listIterator.next().toString());
                    } else {
                        System.err.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;
                case 3:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing: " + listIterator.previous().toString());
                    } else {
                        System.err.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
//                    System.out.println("Select a song number to delete: ");
//                    System.err.println("Are you want to delete "+listIterator.previous());
                    if(playList.size() >0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing: " + listIterator.next());
                        }else if(listIterator.hasPrevious()){
                            System.out.println("Now playing: " + listIterator.previous());
                        }
                    }
                    break;
                case 6:
                    quit=true;
                    break;
                default:
                    System.err.println("Wrong action! Press again");
                    printMenu();
                    break;

            }
        }
    }
    private static void printList(List<Song> linkedList){
        Iterator<Song> i = linkedList.iterator();
        int j = 1;
        System.out.println("------------------------------");
        while(i.hasNext()){
            System.out.println(j++ + ". " +i.next().toString());
        }
        System.out.println("------------------------------");
    }
}
