package ch_14_web_programming_client_side;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class page_715_simple_POST extends JPanel implements ActionListener
{
    JTextField nameFiled, passwordFiled;
    String postURL;

    GridBagConstraints constraints = new GridBagConstraints();

    void addGB(Component component, int x, int y) {
        constraints.gridx = x;
        constraints.gridy = y;
        add(component, constraints);
    }

    public page_715_simple_POST(String postURL) {
        this.postURL = postURL;

        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));
        JButton postButton = new JButton("Post");
        postButton.addActionListener(this);
        setLayout(new GridBagLayout());
        constraints.fill = GridBagConstraints.HORIZONTAL;
        addGB(new JLabel("Name", JLabel.TRAILING), 0, 0);
        addGB(nameFiled = new JTextField(20), 1, 0);
        addGB(new JLabel("Password ", JLabel.TRAILING), 0, 1);
        addGB(passwordFiled = new JPasswordField(20), 1, 1);
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.EAST;
        addGB(postButton, 1, 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        postData();
    }

    protected void postData() {
        StringBuffer sb = new StringBuffer();
        sb.append(URLEncoder.encode("Name") + "=");
        sb.append(URLEncoder.encode(nameFiled.getText()));
        sb.append("&" + URLEncoder.encode("Password") + "=");
        sb.append(passwordFiled.getText());
        String formData = sb.toString();

        try {
            URL url = new URL(postURL);
            HttpURLConnection urlConnection =
                    (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-type",
                    "application/x-www-form-urlencoded");
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            PrintWriter pout = new PrintWriter(new OutputStreamWriter(
                    urlConnection.getOutputStream(), "8859_1"), true
            );
            pout.print(formData);
            pout.flush();

            // read results...
            if ( urlConnection.getResponseCode(  ) != HttpURLConnection.HTTP_OK )
                System.out.println("Posted ok!");
            else {
                System.out.println("Bad post...");
                return;
            }

            InputStream in = urlConnection.getInputStream();
            BufferedReader bin = new BufferedReader(new InputStreamReader(in), 1);
            String line;

            while ((line = bin.readLine()) != null)
                System.out.println(line);
        } catch (MalformedURLException e) {
            System.out.println(e);     // bad postURL
        } catch (IOException e2) {
            System.out.println(e2);    // I/O error
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SimplePost");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new page_715_simple_POST("http://example.com"), "Center");
        frame.pack();
        frame.setVisible(true);
    }
}
