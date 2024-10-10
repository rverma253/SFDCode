from Crypto.Cipher import PKCS1_OAEP
from Crypto.PublicKey import RSA

# Load the public key
with open("public_key.pem", "rb") as f:
    public_key = RSA.import_key(f.read())

cipher_rsa = PKCS1_OAEP.new(public_key)

# Ask the user for input
message = input("Enter the message to encrypt: ")

# Encrypt the message
encrypted_message = cipher_rsa.encrypt(message.encode())

# Write the encrypted message to a file
with open("encrypted_message.bin", "wb") as f:
    f.write(encrypted_message)

print("Encrypted message written to 'encrypted_message.bin'")
