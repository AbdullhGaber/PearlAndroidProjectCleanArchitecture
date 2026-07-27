from flask import Flask, request, jsonify
import tensorflow as tf
import numpy as np
from PIL import Image
import io

# Load the trained model
model = tf.keras.models.load_model(r"C:\Users\hp\AndroidStudioProjects\Projects\JPCProjects\Pearl\assets\AI models\AcneClassification_MobileNetmodel.keras")
class_labels = ['Mild Acne', 'Moderate Acne', 'Severe Acne','Clear']

# Initialize Flask application
app = Flask(__name__)

@app.route('/acne')
def index():
    return 'Welcome to the Acne Severity Classification API!'

# Define a route for prediction
@app.route('/acne/predict', methods=['POST'])
def predict():
    try:
        # Get the image file from the request
        file = request.files['file']

        # Read the image file
        img = Image.open(io.BytesIO(file.read()))

        # Preprocess the image
        img = img.resize((244, 244))  # Resize to match model's expected sizing
        img = np.array(img) / 255.0  # Normalize pixel values
        img = np.expand_dims(img, axis=0)  # Add batch dimension

        # Print debug information
        print(f"Input image shape: {img.shape}")

        # Predict the class probabilities
        pred_prob = model.predict(img)
        pred_class = class_labels[np.argmax(pred_prob)]

        # Print debug information
        print(f"Predicted probabilities: {pred_prob}")
        print(f"Predicted class index: {np.argmax(pred_prob)}")
        print(f"Predicted class: {pred_class}")

        # Format the response as JSON
        response = {'prediction': pred_class, 'confidence': float(pred_prob.max())}
        return jsonify(response)
    except Exception as e:
        return jsonify({'error': str(e)}), 500

# Run the Flask app
if __name__ == '__main__':
    app.run(debug=True)
