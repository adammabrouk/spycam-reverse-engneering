import oss2
import os

# OSS Credentials
access_key_id = "LTAI4Fvp5vkFic1UxLBmVk41"
access_key_secret = "E71ud2gGXTGO4DmR3qhYs9eTytcSuL"
bucket_name = "lookcam"
endpoint = "https://oss-cn-hongkong.aliyuncs.com"  # Use the appropriate region endpoint

# Local directory to store downloaded files
local_download_dir = "./oss_downloads"

# Ensure the download directory exists
os.makedirs(local_download_dir, exist_ok=True)

# Connect to OSS
auth = oss2.Auth(access_key_id, access_key_secret)
bucket = oss2.Bucket(auth, endpoint, bucket_name)

# Download objects
try:
    print(f"Downloading objects from bucket '{bucket_name}' to '{local_download_dir}':")
    for obj in oss2.ObjectIterator(bucket):
        local_file_path = os.path.join(local_download_dir, obj.key)
        os.makedirs(os.path.dirname(local_file_path), exist_ok=True)  # Create necessary directories
        bucket.get_object_to_file(obj.key, local_file_path)
        print(f"Downloaded: {obj.key} -> {local_file_path}")
except oss2.exceptions.ClientError as e:
    print("Error accessing the bucket or downloading objects:", e)
