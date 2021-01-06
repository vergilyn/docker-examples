# Build an image starting with the Python 3.7 image.
FROM python:3.8.7-buster

# Set the working directory to `/code`.
WORKDIR /code

# Set environment variables used by the `flask` command.
ENV FLASK_APP=app.py
ENV FLASK_RUN_HOST=0.0.0.0

# Install gcc and other dependencies
## RUN apk add --no-cache gcc musl-dev linux-headers

# Copy `requirements.txt` and install the Python dependencies.
COPY requirements.txt requirements.txt
RUN pip install -r requirements.txt

# Add metadata to the image to describe that the container is listening on port 5000
EXPOSE 5000

# Copy the current directory `.` in the project to the workdir `.` in the image.
COPY . .

# Set the default command for the container to `flask run`.
CMD ["flask", "run"]