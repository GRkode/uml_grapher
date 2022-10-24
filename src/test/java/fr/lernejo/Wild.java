package fr.lernejo;

public sealed interface Wild {
    sealed interface  Animal extends Wild {
        final class Ant implements Animal {}

        final class Cat implements Animal {}
    }

    sealed interface Plant extends Wild {
        sealed interface Tree extends Plant {
            final class Alder implements Tree {}
        }
    }
}
