import streamlit as st
from api1 import JavaCodeProcessor

logo_url = "logo.png"
st.image(logo_url, width=100, caption="HONQPGen")

# Enthusiastic tagline
st.title("Experience the power of HONQPGen")
st.write("Simplifying Java code documentation with precision, generating class diagrams, and providing method insights for a clearer understanding of your projects.")

uploaded_file = st.file_uploader("Choose a Java file", type=["java"])

if uploaded_file:
    st.success("File successfully uploaded!")

    # Display the Java code input
    java_code = uploaded_file.getvalue().decode("utf-8")
    st.subheader("Java Code Input:")
    st.code(java_code, language="java")

    # Process Java code using the JavaCodeProcessor class
    buffer = JavaCodeProcessor.process_java_code(java_code)

    # Display the Word document output
    st.subheader("Word Document Output:")
    st.write("Here is the Word document containing the Class Diagram and method descriptions generated from your Java code. Feel free to download it!")

    # Download button using the BytesIO buffer
    st.download_button("Download Word Document", data=buffer, file_name="JavaOutputFile.docx", key="word-doc")

    st.success("Word document generated successfully!")
