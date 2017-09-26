import java.util.Arrays;
import java.util.Comparator;

public class Task1 {
    private String[] sortedWords;
    private boolean byStream;

    public Task1(String text, boolean byStream) {
        this.byStream = byStream;

        if (text == null) {
            text = "";
        }

        if (byStream) {
            setByStream(text);
        } else {
            setOldStyle(text);
        }
    }

    private void setByStream(String text) {
        String[] words = this.splitText(text);
        this.sortedWords = Arrays.stream(words)
                .map(String::toLowerCase)
                .distinct()
                .sorted(Comparator.comparingInt(String::length))
                .toArray(String[]::new);
    }

    private void setOldStyle(String text) {
        text = text.toLowerCase();
        String[] words = this.splitText(text);
        Arrays.sort(words, Comparator.comparingInt(String::length));
        this.sortedWords = new String[words.length];
        int i = 0;
        for (String word : words) {
            boolean isFind = false;
            for (String sWord : sortedWords) {
                if (word.equals(sWord)) {
                    isFind = true;
                    break;
                }
            }
            if (!isFind) {
                sortedWords[i++] = word;
            }
        }
    }

    private String[] splitText(String text) {
        return text != null ? text.split("([,.?!;: ]+)|(?<!\\w)-") : new String[0];
    }


    public String[] getSmallestWords() {
        if (this.byStream) {
            return Arrays.stream(this.sortedWords)
                    .filter(str -> str.length() == sortedWords[0].length())
                    .toArray(String[]::new);
        } else {
            int i = 0;
            final int minLength = sortedWords[0].length();
            for (; i < sortedWords.length; i++) {
                String word = sortedWords[i];
                if (word.length() > minLength) {
                    break;
                }
            }
            return Arrays.copyOfRange(sortedWords, 0 , i);
        }
    }

    public String[] getBiggestWords() {
        if (this.byStream) {
            return Arrays.stream(this.sortedWords)
                    .filter(str -> str.length() == sortedWords[sortedWords.length - 1].length())
                    .toArray(String[]::new);
        } else {
            int maxLength = -1;
            int lastIndex = 0;
            int i = sortedWords.length - 1;
            for (; i >= 0; i--) {
                String word = sortedWords[i];
                if (word != null) {
                    if (maxLength == -1) {
                        maxLength = word.length();
                        lastIndex = i;
                    }
                    if (word.length() < maxLength) {
                        break;
                    }
                }
            }
            return Arrays.copyOfRange(sortedWords, i + 1, lastIndex + 1);
        }
    }
}
