public enum Chessmen {
    BLACK_KING("\u265A \t", "bK", "Black"),
    BLACK_QUEEN("\u265B \t", "bQ", "Black"),
    BLACK_ROOK("\u265C \t", "bR", "Black"),
    BLACK_BISHOP("\u265D \t", "bB", "Black"),
    BLACK_KNIGHT("\u265E \t", "bN", "Black"),
    BLACK_PAWN("\u265F \t", "wP", "Black"),
    WHITE_KING("\u2654 \t", "wK", "White"),
    WHITE_QUEEN("\u2655 \t", "wQ", "White"),
    WHITE_ROOK("\u2656 \t", "wR", "White"),
    WHITE_BISHOP("\u2657 \t", "wB", "White"),
    WHITE_KNIGHT("\u2658 \t", "wN", "White"),
    WHITE_PAWN("\u2659 \t", "wP", "White"),
    EMPTY(" \t", " ", " ");

    String character;
    String unicode;
    String colour;

    Chessmen(String unicode, String character, String colour) {
        this.character = character;
        this.unicode = unicode;
        this.colour = colour;
    }

    public String getCharacter() {
        return character;
    }

    public String getUnicode() {
        return unicode;
    }

    public String getColour() {
        return colour;
    }
}