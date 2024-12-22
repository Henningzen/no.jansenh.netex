#!/bin/bash

# URL of the file to be downloaded
URL="https://storage.googleapis.com/marduk-production/outbound/netex/rb_norway-aggregated-netex.zip"

# Directory to save the file
DIRECTORY="./tmp"

# Output file name
OUTPUT_FILE="$DIRECTORY/rb_norway-aggregated-netex.zip"

# Destination directory for unzipping
DESTINATION="./rb_norway-aggregated-netex-latest"

# Create the directory if it doesn't exist
if [ ! -d "$DIRECTORY" ]; then
    mkdir -p "$DIRECTORY"
    echo "Directory '$DIRECTORY' created."
else
    echo "Directory '$DIRECTORY' already exists."
fi

# Use curl to download the file
curl -o "$OUTPUT_FILE" "$URL"

# Check if the download was successful
if [ $? -eq 0 ]; then
    echo "Download completed successfully."

    # Create the destination directory if it doesn't exist
    if [ ! -d "$DESTINATION" ]; then
        mkdir -p "$DESTINATION"
        echo "Directory '$DESTINATION' created."
    else
        echo "Directory '$DESTINATION' already exists."
    fi

    # Unzip the file to the destination directory
    unzip -o "$OUTPUT_FILE" -d "$DESTINATION"

    # Check if the unzip was successful
    if [ $? -eq 0 ]; then
        rm -rf "$DIRECTORY"
        echo "Unzipping completed successfully."
    else
        echo "Unzipping failed."
    fi
else
    echo "Download failed."
fi
