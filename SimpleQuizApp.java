import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleQuizApp extends JFrame {
    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private ButtonGroup optionGroup;
    private JButton submitButton;
    private JLabel timerLabel;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private int timeLeft = 30; 
    private Timer timer;

    private String[][] questions = {
            {"Which company started developing java(as a Green project)?", "Sun Microsystem", "Microsoft", "Oracle", "Apple", "Sun Microsystem"},
            {"What is the value of 2+2=?", "5", "4", "6", "0", "4"},
            {"How many days are there in a week?","5","6","30","7","7"},
    };

    private boolean[] correctAnswers;

    public SimpleQuizApp() {
        setTitle("Quiz Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); 

        JPanel mainPanel = new JPanel(); 
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel);

        questionLabel = new JLabel("Question will appear here");
        questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(questionLabel);

        optionGroup = new ButtonGroup();
        optionButtons = new JRadioButton[4];
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton("Option " + (i + 1));
            optionGroup.add(optionButtons[i]);
            mainPanel.add(optionButtons[i]);
        }

        submitButton = new JButton("Submit Answer");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        checkAnswer();
            }
        });
        mainPanel.add(submitButton);

        timerLabel = new JLabel("Time left: " + timeLeft + " seconds");
        timerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(timerLabel);

        correctAnswers = new boolean[questions.length];
        startQuiz();
    }

    private void startQuiz() {
        showQuestion();
        timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        timeLeft--;
        timerLabel.setText("Time left: " + timeLeft + " seconds");
        if (timeLeft <= 0) {
        timer.stop();
        checkAnswer();
                }
            }
        });
        timer.start();
    }

    private void showQuestion() {
        if (currentQuestionIndex < questions.length) {
        questionLabel.setText(questions[currentQuestionIndex][0]);
        for (int i = 0; i < 4; i++) {
        optionButtons[i].setText(questions[currentQuestionIndex][i + 1]);
            }
        } else {
        showResult();
        }
    }

    private void checkAnswer() {
        String selectedAnswer = null;
        for (JRadioButton button : optionButtons) {
        if (button.isSelected()) {
        selectedAnswer = button.getText();
        break;
            }
        }

        if (selectedAnswer != null && selectedAnswer.equals(questions[currentQuestionIndex][5])) {
        score++;
        correctAnswers[currentQuestionIndex] = true;
        } else {
        correctAnswers[currentQuestionIndex] = false;
        }

        currentQuestionIndex++;
        if (currentQuestionIndex < questions.length) {
       showQuestion();
        resetTimer();
        } else {
        showResult();
        }
    }

    private void showResult() {
        StringBuilder resultMessage = new StringBuilder("Quiz completed!\nYour score: " + score + "/" + questions.length + "\n\nSummary:\n");

        for (int i = 0; i < questions.length; i++) {
        resultMessage.append("Question ").append(i + 1).append(": ");
        if (correctAnswers[i]) {
        resultMessage.append("Correct\n");
        } else {
        resultMessage.append("Incorrect\n");
            }
        }

        JOptionPane.showMessageDialog(this, resultMessage.toString());
        System.exit(0); 
    }

    private void resetTimer() {
        timeLeft = 30;
        timerLabel.setText("Time left: " + timeLeft + " seconds");
        timer.restart();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
        public void run() {
        SimpleQuizApp quizApp = new SimpleQuizApp();
        quizApp.setVisible(true);
            }
        });
    }
}
           